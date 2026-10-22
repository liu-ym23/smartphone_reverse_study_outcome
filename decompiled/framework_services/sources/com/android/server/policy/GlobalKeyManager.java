package com.android.server.policy;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.UserHandle;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.PrintWriter;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class GlobalKeyManager {
    private static final String ATTR_COMPONENT = "component";
    private static final String ATTR_DISPATCH_WHEN_NON_INTERACTIVE = "dispatchWhenNonInteractive";
    private static final String ATTR_KEY_CODE = "keyCode";
    private static final String ATTR_VERSION = "version";
    private static final int GLOBAL_KEY_FILE_VERSION = 1;
    private static final String TAG = "GlobalKeyManager";
    private static final String TAG_GLOBAL_KEYS = "global_keys";
    private static final String TAG_KEY = "key";
    private boolean mBeganFromNonInteractive;
    private final SparseArray<GlobalKeyAction> mKeyMapping;

    class GlobalKeyAction {
        private final ComponentName mComponentName;
        private final boolean mDispatchWhenNonInteractive;

        /* JADX INFO: renamed from: -$$Nest$fgetmComponentName, reason: not valid java name */
        static /* bridge */ /* synthetic */ ComponentName m7130$$Nest$fgetmComponentName(GlobalKeyAction r0) {
            return r0.mComponentName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDispatchWhenNonInteractive, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m7131$$Nest$fgetmDispatchWhenNonInteractive(GlobalKeyAction r0) {
            return r0.mDispatchWhenNonInteractive;
        }

        GlobalKeyAction(GlobalKeyManager this$0, String componentName, String dispatchWhenNonInteractive) {
            this.mComponentName = ComponentName.unflattenFromString(componentName);
            this.mDispatchWhenNonInteractive = Boolean.parseBoolean(dispatchWhenNonInteractive);
        }
    }

    public GlobalKeyManager(Context context) {
        this.mKeyMapping = new SparseArray();
        this.mBeganFromNonInteractive = false;
        loadGlobalKeys(context);
    }

    boolean handleGlobalKey(Context context, int keyCode, KeyEvent event) {
        if (this.mKeyMapping.size() <= 0) goto L10;
        GlobalKeyAction action = this.mKeyMapping.get(keyCode);
        if (action == null) goto L10;
        Intent intent = new GlobalKeyIntent(GlobalKeyAction.m7130$$Nest$fgetmComponentName(action), event, this.mBeganFromNonInteractive).getIntent();
        context.sendBroadcastAsUser(intent, UserHandle.CURRENT, null);
        if (event.getAction() != 1) goto L9;
        this.mBeganFromNonInteractive = false;
    L9:
        return true;
    L10:
        return false;
    }

    boolean shouldHandleGlobalKey(int keyCode) {
        if (this.mKeyMapping.get(keyCode) == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean shouldDispatchFromNonInteractive(int keyCode) {
        GlobalKeyAction action = this.mKeyMapping.get(keyCode);
        if (action != null) goto L7;
        return false;
    L7:
        return GlobalKeyAction.m7131$$Nest$fgetmDispatchWhenNonInteractive(action);
    }

    void setBeganFromNonInteractive() {
        this.mBeganFromNonInteractive = true;
    }

    private void loadGlobalKeys(Context context) {
        XmlResourceParser parser = context.getResources().getXml(R.xml.global_keys);     // Catch: IOException -> L26 XmlPullParserException -> L28 Resources.NotFoundException -> L30
        XmlUtils.beginDocument(parser, TAG_GLOBAL_KEYS);     // Catch: Throwable -> L18
        int version = parser.getAttributeIntValue(null, ATTR_VERSION, 0);     // Catch: Throwable -> L18
        if (1 != version) goto L24;
    L6:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L18
        String element = parser.getName();     // Catch: Throwable -> L18
        if (element == null) goto L24;
        if (TAG_KEY.equals(element) == false) goto L6;
        String keyCodeName = parser.getAttributeValue(null, ATTR_KEY_CODE);     // Catch: Throwable -> L18
        String componentName = parser.getAttributeValue(null, ATTR_COMPONENT);     // Catch: Throwable -> L18
        String dispatchWhenNonInteractive = parser.getAttributeValue(null, ATTR_DISPATCH_WHEN_NON_INTERACTIVE);     // Catch: Throwable -> L18
        if (keyCodeName == null) goto L21;
        if (componentName == null) goto L21;
        int keyCode = KeyEvent.keyCodeFromString(keyCodeName);     // Catch: Throwable -> L18
        if (keyCode != 0) goto L17;
        Log.wtf(TAG, "Global keys entry does not map to a valid key code: " + keyCodeName);     // Catch: Throwable -> L18
        goto L6
    L17:
        this.mKeyMapping.put(keyCode, new GlobalKeyAction(this, componentName, dispatchWhenNonInteractive));     // Catch: Throwable -> L18
    L21:
        Log.wtf(TAG, "Failed to parse global keys entry: " + parser.getText());     // Catch: Throwable -> L18
    L24:
        parser.close();     // Catch: IOException -> L26 XmlPullParserException -> L28 Resources.NotFoundException -> L30
        return;
    L18:
        th = move-exception;
        if (parser != null) goto L45;
    L38:
        throw th;     // Catch: IOException -> L26 XmlPullParserException -> L28 Resources.NotFoundException -> L30
    L45:
        parser.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L26 XmlPullParserException -> L28 Resources.NotFoundException -> L30
    L30:
        e = move-exception;
        Log.wtf(TAG, "global keys file not found", e);
        return;
    L26:
        e = move-exception;
        Log.e(TAG, "I/O exception reading global keys file", e);
        return;
    L28:
        e = move-exception;
        Log.wtf(TAG, "XML parser exception reading global keys file", e);
    }

    public void dump(String prefix, PrintWriter pw) {
        int numKeys = this.mKeyMapping.size();
        if (numKeys != 0) goto L6;
        pw.print(prefix);
        pw.println("mKeyMapping.size=0");
        return;
    L6:
        pw.print(prefix);
        pw.println("mKeyMapping={");
        int i = 0;
    L7:
        if (i >= numKeys) goto L9;
        pw.print("  ");
        pw.print(prefix);
        pw.print(KeyEvent.keyCodeToString(this.mKeyMapping.keyAt(i)));
        pw.print("=");
        pw.print(GlobalKeyAction.m7130$$Nest$fgetmComponentName(this.mKeyMapping.valueAt(i)).flattenToString());
        pw.print(",dispatchWhenNonInteractive=");
        pw.println(GlobalKeyAction.m7131$$Nest$fgetmDispatchWhenNonInteractive(this.mKeyMapping.valueAt(i)));
        i = i + 1;
        goto L7
    L9:
        pw.print(prefix);
        pw.println("}");
    }
}
