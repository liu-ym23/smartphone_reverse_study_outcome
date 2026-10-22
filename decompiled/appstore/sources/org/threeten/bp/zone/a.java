package org.threeten.bp.zone;

import ig.d;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f23244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentNavigableMap f23245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f23246e;

    /* JADX INFO: renamed from: org.threeten.bp.zone.a$a, reason: collision with other inner class name */
    public static class C0336a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f23248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final short[] f23249c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceArray f23250d;

        public C0336a(String r10, String[] r11, short[] r12, AtomicReferenceArray r13) {
            this.f23250d = r13;
            this.f23247a = r10;
            this.f23248b = r11;
            this.f23249c = r12;
        }

        public static /* synthetic */ String a(C0336a r10) {
            return r10.f23247a;
        }

        public ZoneRules b(short r10) {
            Object r11 = this.f23250d.get(r10);
            if ((r11 instanceof byte[]) == false) goto L6;
            r11 = Ser.read(new DataInputStream(new ByteArrayInputStream((byte[]) r11)));
            this.f23250d.set(r10, r11);
        L6:
            return (ZoneRules) r11;
        }

        public ZoneRules c(String r10) {
            int r11 = Arrays.binarySearch(this.f23248b, r10);
            if (r11 >= 0) goto L11;
            return null;
        L11:
            return b(this.f23249c[r11]);
        L8:
            e = move-exception;
            throw new ZoneRulesException("Invalid binary time-zone data: TZDB:" + r10 + ", version: " + this.f23247a, e);
        }

        public String toString() {
            return this.f23247a;
        }
    }

    public a() {
        this.f23245d = new ConcurrentSkipListMap();
        this.f23246e = new CopyOnWriteArraySet();
        if (i(c.class.getClassLoader()) == false) goto L6;
        return;
    L6:
        throw new ZoneRulesException("No time-zone rules found for 'TZDB'");
    }

    @Override // org.threeten.bp.zone.c
    public ZoneRules d(String r10, boolean r11) {
        d.h(r10, "zoneId");
        ZoneRules r12 = ((C0336a) this.f23245d.lastEntry().getValue()).c(r10);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new ZoneRulesException("Unknown time-zone ID: " + r10);
    }

    @Override // org.threeten.bp.zone.c
    public Set e() {
        return new HashSet(this.f23244c);
    }

    public final boolean h(InputStream r10) {
        Iterator r11 = k(r10).iterator();
        boolean r12 = false;
    L4:
        if (r11.hasNext() == false) goto L13;
        C0336a r13 = (C0336a) r11.next();
        C0336a r14 = (C0336a) this.f23245d.putIfAbsent(C0336a.a(r13), r13);
        if (r14 == null) goto L12;
        if (C0336a.a(r14).equals(C0336a.a(r13)) == true) goto L12;
        throw new ZoneRulesException("Data already loaded for TZDB time-zone rules version: " + C0336a.a(r13));
    L12:
        r12 = true;
        goto L4
    L13:
        return r12;
    }

    public final boolean i(ClassLoader r10) {
        URL r11 = null;
        Enumeration<URL> r12 = r10.getResources("org/threeten/bp/TZDB.dat");     // Catch: Exception -> L11
        boolean r13 = false;
    L5:
        if (r12.hasMoreElements() == false) goto L13;
        URL r14 = r12.nextElement();     // Catch: Exception -> L11
        r13 = r13 | j(r14);
        r11 = r14;
    L9:
        e = e;
        r11 = r14;
    L15:
        throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + r11, e);
    L13:
        return r13;
    L11:
        e = e;
        goto L15
    }

    public final boolean j(URL r10) {
        if (this.f23246e.add(r10.toExternalForm()) == true) goto L19;
        return false;
    L19:
        InputStream r11 = r10.openStream();     // Catch: Throwable -> L10
        boolean r12 = h(r11);     // Catch: Throwable -> L8
        if (r11 == null) goto L21;
        r11.close();
        return r12;
    L21:
        return r12;
    L8:
        th = th;
    L12:
        if (r11 == null) goto L14;
        r11.close();
    L14:
        throw th;
    L10:
        th = th;
        r11 = null;
        goto L12
    }

    public final Iterable k(InputStream r12) {
        DataInputStream r10 = new DataInputStream(r12);
        if (r10.readByte() != 1) goto L25;
        if ("TZDB".equals(r10.readUTF()) == false) goto L23;
        int r13 = r10.readShort();
        String[] r11 = new String[r13];
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r11[r14] = r10.readUTF();
        r14 = r14 + 1;
        goto L7
    L9:
        int r15 = r10.readShort();
        String[] r16 = new String[r15];
        int r17 = 0;
    L10:
        if (r17 >= r15) goto L12;
        r16[r17] = r10.readUTF();
        r17 = r17 + 1;
        goto L10
    L12:
        this.f23244c = Arrays.asList(r16);
        int r18 = r10.readShort();
        Object[] r19 = new Object[r18];
        int r20 = 0;
    L13:
        if (r20 >= r18) goto L15;
        byte[] r21 = new byte[r10.readShort()];
        r10.readFully(r21);
        r19[r20] = r21;
        r20 = r20 + 1;
        goto L13
    L15:
        AtomicReferenceArray r110 = new AtomicReferenceArray(r19);
        HashSet r22 = new HashSet(r13);
        int r23 = 0;
    L16:
        if (r23 >= r13) goto L21;
        int r24 = r10.readShort();
        String[] r25 = new String[r24];
        short[] r26 = new short[r24];
        int r27 = 0;
    L18:
        if (r27 >= r24) goto L20;
        r25[r27] = r16[r10.readShort()];
        r26[r27] = r10.readShort();
        r27 = r27 + 1;
        goto L18
    L20:
        r22.add(new C0336a(r11[r23], r25, r26, r110));
        r23 = r23 + 1;
        goto L16
    L21:
        return r22;
    L23:
        throw new StreamCorruptedException("File format not recognised");
    L25:
        throw new StreamCorruptedException("File format not recognised");
    }

    public String toString() {
        return "TZDB";
    }

    public a(InputStream r10) {
        this.f23245d = new ConcurrentSkipListMap();
        this.f23246e = new CopyOnWriteArraySet();
        h(r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new ZoneRulesException("Unable to load TZDB time-zone rules", e);
    }
}
