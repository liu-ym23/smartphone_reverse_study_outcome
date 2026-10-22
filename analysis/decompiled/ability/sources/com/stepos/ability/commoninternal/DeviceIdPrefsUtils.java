package com.stepos.ability.commoninternal;

import P3.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import androidx.constraintlayout.core.dsl.a;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.AbstractC1607a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stepos/ability/commoninternal/DeviceIdPrefsUtils;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "PREF_NAME", "KEY_DEVICE_ID", "read", "context", "Landroid/content/Context;", "write", "", "id", "generateNewId", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "sha256", "input", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceIdPrefsUtils {
    public static final DeviceIdPrefsUtils INSTANCE = new DeviceIdPrefsUtils();
    private static final String KEY_DEVICE_ID = "com.stepos.ability.DEVICE_ID";
    private static final String PREF_NAME = "stepos_ability_device_id";
    private static final String TAG = "DeviceIdPrefsUtils";

    private DeviceIdPrefsUtils() {
    }

    private final SharedPreferences prefs(Context context) {
        return context.getApplicationContext().getSharedPreferences(PREF_NAME, 0);
    }

    private final String sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = input.getBytes(AbstractC1607a.f4778a);
        k.e(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        k.c(bArrDigest);
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i = 0;
        for (byte b : bArrDigest) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) "");
            }
            sb.append(sha256$lambda$0(b));
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    private static final CharSequence sha256$lambda$0(byte b) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
    }

    public final String generateNewId(Context context) {
        k.f(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string != null && string.length() != 0 && !k.b(string, "9774d56d682e549c")) {
            return sha256(string);
        }
        String string2 = UUID.randomUUID().toString();
        k.c(string2);
        return string2;
    }

    public final String read(Context context) {
        k.f(context, "context");
        try {
            return prefs(context).getString(KEY_DEVICE_ID, null);
        } catch (Exception e) {
            c.f1086a.invoke(6, "Ability_".concat(TAG), "Failed to read device id from prefs.", e);
            return null;
        }
    }

    public final boolean write(Context context, String id) {
        k.f(context, "context");
        k.f(id, "id");
        try {
            SharedPreferences sharedPreferencesPrefs = prefs(context);
            k.e(sharedPreferencesPrefs, "prefs(...)");
            SharedPreferences.Editor editorEdit = sharedPreferencesPrefs.edit();
            editorEdit.putString(KEY_DEVICE_ID, id);
            editorEdit.apply();
            return true;
        } catch (Exception e) {
            String strH = a.h("Failed to write device id to prefs. Msg:", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE);
            c.f1086a.invoke(6, "Ability_".concat(TAG), strH, e);
            return false;
        }
    }
}
