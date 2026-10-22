package com.android.server.inputmethod;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.ArrayMap;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@FunctionalInterface
interface SecureSettingsChangeCallback {

    /* JADX INFO: renamed from: com.android.server.inputmethod.SecureSettingsChangeCallback$1, reason: invalid class name */
    class AnonymousClass1 extends ContentObserver {
        final /* synthetic */ SecureSettingsChangeCallback val$callback;
        final /* synthetic */ ArrayMap val$uriMapper;

        public static /* synthetic */ void $r8$lambda$mUm7_MlRs_rYS4P5EhwmlKuzLDM(ArrayMap r0, SecureSettingsChangeCallback r1, int r2, int r3, Uri r4) {
            lambda$onChange$0(r0, r1, r2, r3, r4);
        }

        AnonymousClass1(Handler handler, ArrayMap r2, SecureSettingsChangeCallback r3) {
            this.val$uriMapper = r2;
            this.val$callback = r3;
            super(handler);
        }

        public void onChange(boolean selfChange, Collection<Uri> uris, final int flags, final int userId) {
            final ArrayMap r0 = this.val$uriMapper;
            final SecureSettingsChangeCallback r1 = this.val$callback;
            uris.forEach(new SecureSettingsChangeCallback$1$$ExternalSyntheticLambda0(r0, r1, flags, userId));
        }

        private static /* synthetic */ void lambda$onChange$0(ArrayMap uriMapper, SecureSettingsChangeCallback callback, int flags, int userId, Uri uri) {
            String key = (String) uriMapper.get(uri);
            if (key == null) goto L6;
            callback.onChange(key, flags, userId);
            return;
        }
    }

    void onChange(String r1, int r2, int r3);

    static void register(Handler handler, ContentResolver resolver, String[] keys, SecureSettingsChangeCallback callback) {
        ArrayMap<Uri, String> uriMapper = new ArrayMap();
        int r1 = keys.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        String key = keys[r3];
        uriMapper.put(Settings.Secure.getUriFor(key), key);
        r3 = r3 + 1;
        goto L3
    L5:
        ContentObserver observer = new AnonymousClass1(handler, uriMapper, callback);
        Iterator<Uri> r4 = uriMapper.keySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        Uri uri = r4.next();
        resolver.registerContentObserverAsUser(uri, false, observer, UserHandle.ALL);
        goto L7
    }
}
