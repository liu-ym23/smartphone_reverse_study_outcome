package com.android.server.inputmethod;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.pico.utils.IExtBase;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodInfo;
import android.window.ImeOnBackInvokedDispatcher;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;
import com.android.internal.inputmethod.IRemoteInputConnection;
import com.android.internal.inputmethod.InputBindResult;
import com.android.internal.view.IInputMethodManagerExt;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtInputMethodManagerService extends IExtBase {

    public interface IExtInputMethodManagerServiceCallback {
        void onRealConnectionNull();

        default void onRealConnectionAvailable() {
        }
    }

    void addRealConnectionAvailableCallback(IExtInputMethodManagerServiceCallback r1);

    void addRealConnectionNullCallback(IExtInputMethodManagerServiceCallback r1);

    InputBindResult bindMethod(InputMethodBindingController r1);

    void buildInputMethodListLocked(InputMethodMap r1);

    void forceResetAiWriting(ComponentName r1);

    int getAppShowFlags();

    IInputMethodManagerExt getIExt();

    int getImeShowFlags();

    void getInputMethodListLocked(ArrayList<InputMethodInfo> r1);

    int getInputMethodNavButtonFlagsLocked(UserData r1, EditorInfo r2, int r3);

    IRemoteInputConnection getRealInputConnection();

    ResultReceiver getResultReceiver(EditorInfo r1);

    String getSuitableMethod(InputMethodBindingController r1);

    void hideCurrentInputLocked();

    void init(Looper r1);

    boolean isSuitableMethodBoundLocked(InputMethodBindingController r1, int r2, int r3);

    void onAttributeChange(EditorInfo r1, ClientState r2, UserData r3);

    void onChange(boolean r1, Uri r2);

    void onHideInputMethodMenu();

    void onImeWindowStatusChanged(int r1);

    void onListAdapterGetView(View r1, boolean r2);

    void onShowInputMethodMenu(AlertDialog r1);

    boolean onTransact(int r1, Parcel r2, Parcel r3, int r4);

    void registerContentObserverLocked(ContentResolver r1, int r2, ContentObserver r3);

    void removeRealConnectionAvailableCallback(IExtInputMethodManagerServiceCallback r1);

    void removeRealConnectionNullCallback(IExtInputMethodManagerServiceCallback r1);

    void setFakeInputConnection(IRemoteInputConnection r1, int r2, int r3, CharSequence r4);

    void setRealInputConnection(IRemoteInputConnection r1);

    boolean shouldIgnoreShowSoftInput(int r1);

    boolean shouldShowImeSwitcher(EditorInfo r1);

    void showCurrentInputLocked(IInputMethodInvoker r1, EditorInfo r2, ResultReceiver r3, int r4);

    InputBindResult startInput(IBinder r1, ClientState r2, IRemoteInputConnection r3, IRemoteAccessibilityInputConnection r4, EditorInfo r5, int r6, int r7, int r8, ImeOnBackInvokedDispatcher r9, InputMethodBindingController r10, int r11, UserData r12);

    void systemRunning();
}
