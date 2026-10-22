package stepos.inputmethod;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.inputmethod.EditorInfo;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import stepos.inputmethod.IQsActionCallback;
import stepos.inputmethod.IQsManagerService;

/* loaded from: classes.dex */
public class QsActionManager {
    public static final String ACTION_NAME = "stepos.service.inputmethod.action.QS_TILE";
    public static final String CLIP_PASTE_ACTION_NAME = "clip_paste";
    public static String DATA_KEY = "ext:key";
    public static final boolean DEBUG = true;
    public static final boolean DEFAULT_ENABLE = false;
    public static final String EMPTY_ACTION_NAME = "NULL";
    public static final String IME_SWITCH_ACTION_NAME = "ime_switch";
    public static final int ITEM_ACTION_DATA_CHANGE = 0;
    public static final int ITEM_ACTION_ICON_CLICK = 7;
    public static final int ITEM_ACTION_ICON_LONG_PRESS = 8;
    public static final int ITEM_ACTION_IME_HIDE_APP = 3;
    public static final int ITEM_ACTION_IME_HIDE_IME = 4;
    public static final int ITEM_ACTION_IME_SHOW = 2;
    public static final int ITEM_ACTION_IME_START = 5;
    public static final int ITEM_ACTION_IME_STOP = 6;
    public static final int ITEM_ACTION_KEYGUARD_HIDE = 10;
    public static final int ITEM_ACTION_KEYGUARD_SHOW = 9;
    public static final int ITEM_ACTION_STATE_CHANGE = 1;
    public static final int ITEM_ACTION_SYSTEM_UI_VISIBILITY_CHANGE = 11;
    public static final int ITEM_POSITION_ALL = 65535;
    public static final int ITEM_POSITION_CENTER = 2;
    public static final int ITEM_POSITION_LEFT = 1;
    public static final int ITEM_POSITION_MESSAGE = 16;
    public static final int ITEM_POSITION_RIGHT = 4;
    public static final int ITEM_POSITION_SHOW = -1;
    public static final int ITEM_POSITION_SLIDE = 8;
    public static final int ITEM_POSITION_UNKNOWN = 0;
    public static final int ITEM_STATE_DISABLE = 2;
    public static final int ITEM_STATE_GONE = 1;
    public static final int ITEM_STATE_NORMAL = 0;
    public static final int ITEM_TYPE_ACTIVE = 2;
    public static final int ITEM_TYPE_ALWAYS = 3;
    public static final int ITEM_TYPE_CLICK = 1;
    public static final String MESSAGE_ENABLE = "stepos.setting.inputmethod.captcha.enable";
    public static final String SERVICE_NAME = "input_method_qs";
    public static final String SETTING_CENTER = "stepos.setting.inputmethod.action.center";
    public static final String SETTING_ENABLE = "stepos.setting.inputmethod.action.enable";
    public static final String SETTING_LEFT = "stepos.setting.inputmethod.action.left";
    public static final String SETTING_RIGHT = "stepos.setting.inputmethod.action.right";
    public static final String SETTING_SLIDE = "stepos.setting.inputmethod.action.slide";
    public static final String SLIDE_ACTION_NAME = "slide";
    public static final String TAG = "QsActionManager";
    public static final String VOICE_ASSISTANT_ENABLE = "stepos.setting.inputmethod.voice.assistant.enable";
    private static QsActionManager sInstance;
    private final Context mContext;
    private IQsManagerService mService;

    public @interface Action {
    }

    public @interface Position {
    }

    public @interface State {
    }

    public @interface Type {
    }

    public interface QsActionCallback {
        default void onItemDataChange(QsActionItem actionItem) {
        }

        default void onItemActionEnable(int displayId, boolean enable) {
        }

        default void onInputMethodShow(int displayId, int userId, Bundle data) {
        }

        default void onInputMethodHideByApp(int displayId, int userId, Bundle data) {
        }

        default void onInputMethodHideByIme(int displayId, int userId, Bundle data) {
        }

        default void onStartListening(int displayId, int userId, Bundle data) {
        }

        default void onStopListening(int displayId, int userId, Bundle data) {
        }

        default void onClick(int displayId, int userId, Bundle data) {
        }

        default void onLongPress(int displayId, int userId, Bundle data) {
        }

        default void onKeyguardShow(int displayId, int userId, Bundle data) {
        }

        default void onKeyguardHide(int displayId, int userId, Bundle data) {
        }

        default void onSystemUIVisibilityChange(int displayId, boolean removeWindow) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class QsActionCallbackProxy extends IQsActionCallback.Stub {
        private final QsActionCallback mCallback;
        private final H mHandler;

        public QsActionCallbackProxy(QsActionCallback callback, Looper looper) {
            this.mCallback = callback;
            this.mHandler = new H(looper);
        }

        private class H extends Handler {
            public H(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        QsActionCallbackProxy.this.mCallback.onItemDataChange((QsActionItem) msg.obj);
                        break;
                    case 1:
                        QsActionCallbackProxy.this.mCallback.onItemActionEnable(msg.arg1, msg.arg2 == 1);
                        break;
                    case 2:
                        QsActionCallbackProxy.this.mCallback.onInputMethodShow(msg.arg1, msg.arg2, (Bundle) msg.obj);
                        break;
                    case 3:
                        QsActionCallbackProxy.this.mCallback.onInputMethodHideByApp(msg.arg1, msg.arg2, (Bundle) msg.obj);
                        break;
                    case 4:
                        QsActionCallbackProxy.this.mCallback.onInputMethodHideByIme(msg.arg1, msg.arg2, (Bundle) msg.obj);
                        break;
                    case 5:
                        QsActionCallbackProxy.this.mCallback.onStartListening(msg.arg1, msg.arg2, (Bundle) msg.obj);
                        break;
                    case 6:
                        QsActionCallbackProxy.this.mCallback.onStopListening(msg.arg1, msg.arg2, (Bundle) msg.obj);
                        break;
                    case 7:
                        QsActionCallbackProxy.this.mCallback.onClick(msg.arg1, msg.arg2, (Bundle) msg.obj);
                        break;
                    case 8:
                        QsActionCallbackProxy.this.mCallback.onLongPress(msg.arg1, msg.arg2, (Bundle) msg.obj);
                        break;
                    case 9:
                        QsActionCallbackProxy.this.mCallback.onKeyguardShow(msg.arg1, msg.arg2, (Bundle) msg.obj);
                        break;
                    case 10:
                        QsActionCallbackProxy.this.mCallback.onKeyguardHide(msg.arg1, msg.arg2, (Bundle) msg.obj);
                        break;
                    case 11:
                        QsActionCallbackProxy.this.mCallback.onSystemUIVisibilityChange(msg.arg1, msg.arg2 == 1);
                        break;
                }
            }
        }

        @Override // stepos.inputmethod.IQsActionCallback
        public void onItemActionCall(int action, int displayId, int userId, Bundle data) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(action, displayId, userId, data));
        }

        @Override // stepos.inputmethod.IQsActionCallback
        public void onItemDataChange(QsActionItem actionItem) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(0, 0, 0, actionItem));
        }

        @Override // stepos.inputmethod.IQsActionCallback
        public void onItemActionEnable(int i, boolean z) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i, z ? 1 : 0));
        }

        @Override // stepos.inputmethod.IQsActionCallback
        public void onSystemUiVisibilityChange(int i, boolean z) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(11, i, z ? 1 : 0));
        }
    }

    public static void enforceCallingPermission(Context context, String message) {
        if (Binder.getCallingUid() != 1000) {
            context.enforceCallingPermission(StepOSInputMethodQsPermissions.BIND_INPUT_METHOD_ITEM, message);
        }
    }

    public static QsActionCallbackProxy createActionCallback(QsActionCallback callback, Looper looper) {
        return new QsActionCallbackProxy(callback, looper);
    }

    public static QsActionManager getInstance(Context context) {
        QsActionManager qsActionManager;
        synchronized (QsActionManager.class) {
            if (sInstance == null) {
                sInstance = new QsActionManager(context);
            }
            qsActionManager = sInstance;
        }
        return qsActionManager;
    }

    private QsActionManager(Context context) {
        this.mContext = context.getApplicationContext();
        IBinder binder = StepOSWindowExtHelper.getSubService(SERVICE_NAME);
        if (binder != null) {
            this.mService = IQsManagerService.Stub.asInterface(binder);
        }
    }

    private IQsManagerService getService() {
        IBinder binder;
        if (this.mService == null && (binder = StepOSWindowExtHelper.getSubService(SERVICE_NAME)) != null) {
            this.mService = IQsManagerService.Stub.asInterface(binder);
        }
        return this.mService;
    }

    @Deprecated
    public void updateAction(QsActionItem item) {
        updateActionItem(item);
    }

    public void updateActionItem(QsActionItem item) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.updateActionItem(-2, item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public QsActionItem showTextAtIme(Icon icon, CharSequence showText, CharSequence inputText, int intervalSec, int showSeconds) {
        return showTextAtIme(-1, icon, showText, inputText, intervalSec, showSeconds, null);
    }

    public QsActionItem showTextAtIme(Icon icon, CharSequence showText, IQsActionCallback callBack) {
        return showTextAtIme(-1, icon, showText, null, 0, 0, callBack);
    }

    public QsActionItem showTextAtIme(int displayId, Icon icon, CharSequence showText, CharSequence inputText, int intervalSec, int showSeconds, IQsActionCallback callBack) {
        Random random = new Random(this.mContext.getPackageName().length() * System.nanoTime());
        QsActionItem item = QsActionItem.create("showText_" + random.nextLong(), this.mContext);
        item.setIcon(icon);
        item.setInput(inputText);
        item.setLabel(showText);
        item.setDisplayId(displayId);
        item.setPosition(16);
        item.setExpiryTime(System.currentTimeMillis() + (intervalSec * 1000));
        item.setShowSeconds(showSeconds);
        registerActionItem(item, callBack);
        return null;
    }

    public QsActionItem registerActionItem(CharSequence ID, CharSequence label, Icon icon, IQsActionCallback callBack) {
        QsActionItem item = QsActionItem.create(ID, this.mContext);
        item.setLabel(label);
        item.setIcon(icon);
        return registerActionItem(item, callBack);
    }

    public QsActionItem registerActionItem(QsActionItem item, IQsActionCallback callBack) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return null;
            }
            service.registerActionItem(-2, item, callBack);
            return item;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void unRegisterActionItem(QsActionItem item) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.unRegisterActionItem(-2, item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerActionListener(IQsActionListener listener) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.registerActionListener(-2, listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unRegisterActionListener(IQsActionListener listener) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.unRegisterActionListener(-2, listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<QsActionItem> getActionItemList(int position) {
        List<QsActionItem> result;
        try {
            IQsManagerService service = getService();
            if (service != null && (result = service.getActionItemList(-2, position)) != null) {
                return result;
            }
            return Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void registerActionExecutor(int displayId, IQsActionExecutor executor) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.registerActionExecutor(displayId, -2, executor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unRegisterActionExecutor(int displayId, IQsActionExecutor executor) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.unRegisterActionExecutor(displayId, -2, executor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callItemAction(CharSequence itemKey, int action, int displayId, int userId, Bundle data) {
        Exception e;
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            try {
                service.callItemAction(itemKey, action, displayId, userId, data);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void callItemActionSystemUiVisibilityChange(int displayId, boolean removeWindow) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.callItemActionSystemUiVisibilityChange(displayId, removeWindow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IQsActionExecutor getActionExecutor(int displayId, long token) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return null;
            }
            return service.getActionExecutor(displayId, token);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setVirtualImeHeight(int displayId, int height) {
        StepOSWindowExtHelper.setVirtualImeHeight(displayId, height);
    }

    public int getImeHeight(int displayId) {
        return getImeHeight(displayId, false);
    }

    public int getImeHeight(int displayId, boolean virtual) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return 0;
            }
            return service.getImeHeight(displayId, virtual);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isEnable(int displayId) {
        try {
            IQsManagerService service = getService();
            if (service != null) {
                return service.isEnable(displayId);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void registerEditorListener(IQsEditorListener listener) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.registerEditorListener(-2, listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unRegisterEditorListener(IQsEditorListener listener) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.unRegisterEditorListener(-2, listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onAppEditorBegin(int userId, int displayId, EditorInfo editorInfo) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.onAppEditorBegin(userId, displayId, editorInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onAppEditorTextChange(int userId, int displayId, CharSequence text) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.onAppEditorTextChange(userId, displayId, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onAppEditorEnd(int userId, int displayId) {
        try {
            IQsManagerService service = getService();
            if (service == null) {
                return;
            }
            service.onAppEditorEnd(userId, displayId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
