package com.android.server.locksettings;

import android.os.SystemProperties;
import android.util.Slog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class PasswordSlotManager {
    private static final String GSI_RUNNING_PROP = "ro.gsid.image_running";
    private static final String SLOT_MAP_DIR = "/metadata/password_slots";
    private static final String TAG = "PasswordSlotManager";
    private Set<Integer> mActiveSlots;
    private Map<Integer, String> mSlotMap;

    public PasswordSlotManager() {
    }

    protected String getSlotMapDir() {
        return SLOT_MAP_DIR;
    }

    protected int getGsiImageNumber() {
        return SystemProperties.getInt(GSI_RUNNING_PROP, 0);
    }

    public void refreshActiveSlots(Set<Integer> activeSlots) throws RuntimeException {
        if (this.mSlotMap != null) goto L6;
        this.mActiveSlots = new HashSet(activeSlots);
        return;
    L6:
        HashSet<Integer> slotsToDelete = new HashSet();
        Iterator<Map.Entry<Integer, String>> r1 = this.mSlotMap.entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        Map.Entry<Integer, String> entry = r1.next();
        if (entry.getValue().equals(getMode()) == false) goto L8;
        slotsToDelete.add(entry.getKey());
        goto L8
    L13:
        Iterator<Integer> r2 = slotsToDelete.iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        Integer slot = r2.next();
        this.mSlotMap.remove(slot);
        goto L15
    L17:
        Iterator<Integer> r3 = activeSlots.iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        Integer slot2 = r3.next();
        this.mSlotMap.put(slot2, getMode());
        goto L19
    L21:
        saveSlotMap();
    }

    public void markSlotInUse(int slot) throws RuntimeException {
        ensureSlotMapLoaded();
        if (this.mSlotMap.containsKey(Integer.valueOf(slot)) == true) goto L5;
    L9:
        this.mSlotMap.put(Integer.valueOf(slot), getMode());
        saveSlotMap();
        return;
    L5:
        if (this.mSlotMap.get(Integer.valueOf(slot)).equals(getMode()) == true) goto L9;
        throw new IllegalStateException("password slot " + slot + " is not available");
    }

    public void markSlotDeleted(int slot) throws RuntimeException {
        ensureSlotMapLoaded();
        if (this.mSlotMap.containsKey(Integer.valueOf(slot)) == true) goto L5;
    L9:
        this.mSlotMap.remove(Integer.valueOf(slot));
        saveSlotMap();
        return;
    L5:
        if (this.mSlotMap.get(Integer.valueOf(slot)).equals(getMode()) == true) goto L9;
        throw new IllegalStateException("password slot " + slot + " cannot be deleted");
    }

    public Set<Integer> getUsedSlots() {
        ensureSlotMapLoaded();
        return Collections.unmodifiableSet(this.mSlotMap.keySet());
    }

    private File getSlotMapFile() {
        return Paths.get(getSlotMapDir(), new String[]{"slot_map"}).toFile();
    }

    private String getMode() {
        int gsiIndex = getGsiImageNumber();
        if (gsiIndex > 0) goto L5;
        return "host";
    L5:
        return "gsi" + gsiIndex;
    }

    protected Map<Integer, String> loadSlotMap(InputStream stream) throws IOException {
        HashMap<Integer, String> map = new HashMap();
        Properties props = new Properties();
        props.load(stream);
        Iterator<String> r2 = props.stringPropertyNames().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String slotString = r2.next();
        int slot = Integer.parseInt(slotString);
        String owner = props.getProperty(slotString);
        map.put(Integer.valueOf(slot), owner);
        goto L4
    L6:
        return map;
    }

    private Map<Integer, String> loadSlotMap() {
        File file = getSlotMapFile();
        if (file.exists() == false) goto L18;
        FileInputStream stream = new FileInputStream(file);     // Catch: Exception -> L8
        Map<Integer, String> r2 = loadSlotMap(stream);     // Catch: Throwable -> L10
        stream.close();     // Catch: Exception -> L8
        return r2;
    L10:
        th = move-exception;
        stream.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: Exception -> L8
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Could not load slot map file", e);
    L18:
        return new HashMap();
    }

    private void ensureSlotMapLoaded() {
        if (this.mSlotMap != null) goto L8;
        this.mSlotMap = loadSlotMap();
        if (this.mActiveSlots == null) goto L9;
        refreshActiveSlots(this.mActiveSlots);
        this.mActiveSlots = null;
        return;
    L9:
        return;
    }

    protected void saveSlotMap(OutputStream stream) throws IOException {
        if (this.mSlotMap != null) goto L5;
        return;
    L5:
        Properties props = new Properties();
        Iterator<Map.Entry<Integer, String>> r1 = this.mSlotMap.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry<Integer, String> entry = r1.next();
        props.setProperty(entry.getKey().toString(), entry.getValue());
        goto L7
    L9:
        props.store(stream, "");
    }

    private void saveSlotMap() {
        if (this.mSlotMap != null) goto L6;
        return;
    L6:
        if (getSlotMapFile().getParentFile().exists() == true) goto L25;
        Slog.w(TAG, "Not saving slot map, " + getSlotMapDir() + " does not exist");
        return;
    L25:
        FileOutputStream fos = new FileOutputStream(getSlotMapFile());     // Catch: IOException -> L13
        saveSlotMap(fos);     // Catch: Throwable -> L15
        fos.close();     // Catch: IOException -> L13
        return;
    L15:
        th = move-exception;
        fos.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: IOException -> L13
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "failed to save password slot map", e);
    }
}
