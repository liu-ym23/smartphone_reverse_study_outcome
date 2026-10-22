package com.stepos.launcher.assistant.widgetdrag;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.DragEvent;
import com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent;
import com.stepos.launcher.assistant.utils.XLog;
import com.stepos.launcher.assistant.widgetdrag.DragBundleParser;
import com.stepos.launcher.client.libraries.ILauncherWidgetDragCallback;

/* loaded from: classes.dex */
public class ScrollOverlayWidgetComponent extends ScrollOverlayComponent implements IOverlayAssistantCallBack, IOverlayWidgetComponent {
    private static final String TAG = "GlobalWidgetDrag";
    private IOverlayWidgetCallBack mOverlayWidgetCallBack;
    private ILauncherWidgetDragCallback mWidgetDragProxyCallbacks;

    public ScrollOverlayWidgetComponent(Context context) {
        super(context);
    }

    private Bundle sendWidgetDragBundle(Bundle bundle) {
        try {
            ILauncherWidgetDragCallback iLauncherWidgetDragCallback = this.mWidgetDragProxyCallbacks;
            if (iLauncherWidgetDragCallback != null) {
                return iLauncherWidgetDragCallback.onGetDragBundle(bundle);
            }
            return null;
        } catch (RemoteException unused) {
            XLog.i(TAG, "sendWidgetDragBundle error.");
            return null;
        }
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IOverlayAssistantCallBack
    public DragEvent getDragEvent(int i10) {
        Bundle bundleSendWidgetDragBundle = sendWidgetDragBundle(DragBundleParser.parseGetDragEvent(i10));
        if (bundleSendWidgetDragBundle != null) {
            return (DragEvent) bundleSendWidgetDragBundle.getParcelable(DragBundleParser.Key.DRAG_EVENT);
        }
        return null;
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IOverlayAssistantCallBack
    public boolean isLauncherWidgetDragEnable() {
        Bundle bundleSendWidgetDragBundle = sendWidgetDragBundle(DragBundleParser.parseWidgetDragEnableEvent());
        if (bundleSendWidgetDragBundle != null) {
            return bundleSendWidgetDragBundle.getBoolean("result");
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    @Override // com.stepos.launcher.assistant.widgetdrag.IOverlayWidgetComponent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle onReceiveWidgetDragBundle(android.os.Bundle r5) {
        /*
            r4 = this;
            if (r5 == 0) goto La3
            com.stepos.launcher.assistant.widgetdrag.IOverlayWidgetCallBack r0 = r4.mOverlayWidgetCallBack
            if (r0 != 0) goto L8
            goto La3
        L8:
            java.lang.String r0 = "event"
            java.lang.String r1 = ""
            java.lang.String r0 = r5.getString(r0, r1)
            r0.getClass()
            int r1 = r0.hashCode()
            r2 = -1
            switch(r1) {
                case -1572097063: goto L49;
                case 402111341: goto L3e;
                case 1261250322: goto L33;
                case 1675051260: goto L28;
                case 2001420376: goto L1d;
                default: goto L1b;
            }
        L1b:
            r1 = r2
            goto L53
        L1d:
            java.lang.String r1 = "get_drag_event"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L26
            goto L1b
        L26:
            r1 = 4
            goto L53
        L28:
            java.lang.String r1 = "get_widget_drag_enable"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L31
            goto L1b
        L31:
            r1 = 3
            goto L53
        L33:
            java.lang.String r1 = "drop_start"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L3c
            goto L1b
        L3c:
            r1 = 2
            goto L53
        L3e:
            java.lang.String r1 = "drop_result"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L47
            goto L1b
        L47:
            r1 = 1
            goto L53
        L49:
            java.lang.String r1 = "cancel_drag"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L52
            goto L1b
        L52:
            r1 = 0
        L53:
            java.lang.String r3 = "result"
            switch(r1) {
                case 0: goto L9d;
                case 1: goto L93;
                case 2: goto L8d;
                case 3: goto L83;
                case 4: goto L6f;
                default: goto L58;
            }
        L58:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "onGetDragBundle parseBundle error event:"
            r4.append(r1)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "GlobalWidgetDrag"
            android.util.Log.e(r0, r4)
            return r5
        L6f:
            java.lang.String r0 = "drag_event_type"
            int r0 = r5.getInt(r0, r2)
            if (r0 == r2) goto L82
            com.stepos.launcher.assistant.widgetdrag.IOverlayWidgetCallBack r4 = r4.mOverlayWidgetCallBack
            android.view.DragEvent r4 = r4.onGetDragEvent(r0)
            java.lang.String r0 = "drag_event"
            r5.putParcelable(r0, r4)
        L82:
            return r5
        L83:
            com.stepos.launcher.assistant.widgetdrag.IOverlayWidgetCallBack r4 = r4.mOverlayWidgetCallBack
            boolean r4 = r4.isAssistantWidgetDragEnable()
            r5.putBoolean(r3, r4)
            return r5
        L8d:
            com.stepos.launcher.assistant.widgetdrag.IOverlayWidgetCallBack r4 = r4.mOverlayWidgetCallBack
            r4.onWidgetDropStart()
            return r5
        L93:
            boolean r0 = r5.getBoolean(r3)
            com.stepos.launcher.assistant.widgetdrag.IOverlayWidgetCallBack r4 = r4.mOverlayWidgetCallBack
            r4.onWidgetDropResult(r0)
            return r5
        L9d:
            com.stepos.launcher.assistant.widgetdrag.IOverlayWidgetCallBack r4 = r4.mOverlayWidgetCallBack
            r4.onCancelWidgetDrag()
            return r5
        La3:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.launcher.assistant.widgetdrag.ScrollOverlayWidgetComponent.onReceiveWidgetDragBundle(android.os.Bundle):android.os.Bundle");
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IOverlayAssistantCallBack
    public void sendDropWidgetResult(boolean z10) {
        sendWidgetDragBundle(DragBundleParser.parseDropResultEvent(z10));
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IOverlayAssistantCallBack
    public void sendWidgetDropStart() {
        sendWidgetDragBundle(DragBundleParser.parseStartDropEvent());
    }

    public void setOverlayWidgetCallBack(IOverlayWidgetCallBack iOverlayWidgetCallBack) {
        this.mOverlayWidgetCallBack = iOverlayWidgetCallBack;
    }

    @Override // com.stepos.launcher.assistant.widgetdrag.IOverlayWidgetComponent
    public void setWidgetDragProxyCallbacks(ILauncherWidgetDragCallback iLauncherWidgetDragCallback) {
        this.mWidgetDragProxyCallbacks = iLauncherWidgetDragCallback;
    }
}
