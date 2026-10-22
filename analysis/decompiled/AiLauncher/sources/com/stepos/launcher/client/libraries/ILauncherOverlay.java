package com.stepos.launcher.client.libraries;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.stepos.launcher.client.libraries.ILauncherOverlayCallback;
import com.stepos.launcher.client.libraries.ILauncherWidgetDragCallback;

/* loaded from: classes.dex */
public interface ILauncherOverlay extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.launcher.client.libraries.ILauncherOverlay";

    public static class Default implements ILauncherOverlay {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void bindWidgetDragCallbacks(ILauncherWidgetDragCallback iLauncherWidgetDragCallback) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void closeOverlay(int i10) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void endScroll() throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public boolean isOverlayOpened() throws RemoteException {
            return false;
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void navigateToDefaultPage() throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void onBackPressed() throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void onFlingVelocity(float f10) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void onPause() throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void onProxyTouch(MotionEvent motionEvent) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void onRemoteTransitionEnd(Bundle bundle) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void onRemoteTransitionStart(Bundle bundle) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void onResume() throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void onScroll(float f10) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void onStart() throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void onStop() throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public Bundle onWidgetDragBundle(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void openOverlay(int i10) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void setOverlayViewProperties(Bundle bundle) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void startScroll() throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void stateChange(int i10) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void windowAttached(WindowManager.LayoutParams layoutParams, ILauncherOverlayCallback iLauncherOverlayCallback, int i10) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void windowAttached2(Bundle bundle, ILauncherOverlayCallback iLauncherOverlayCallback) throws RemoteException {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
        public void windowDetached(boolean z10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ILauncherOverlay {
        static final int TRANSACTION_bindWidgetDragCallbacks = 18;
        static final int TRANSACTION_closeOverlay = 2;
        static final int TRANSACTION_endScroll = 7;
        static final int TRANSACTION_isOverlayOpened = 16;
        static final int TRANSACTION_navigateToDefaultPage = 10;
        static final int TRANSACTION_onBackPressed = 9;
        static final int TRANSACTION_onFlingVelocity = 23;
        static final int TRANSACTION_onPause = 11;
        static final int TRANSACTION_onProxyTouch = 22;
        static final int TRANSACTION_onRemoteTransitionEnd = 21;
        static final int TRANSACTION_onRemoteTransitionStart = 20;
        static final int TRANSACTION_onResume = 13;
        static final int TRANSACTION_onScroll = 1;
        static final int TRANSACTION_onStart = 14;
        static final int TRANSACTION_onStop = 15;
        static final int TRANSACTION_onWidgetDragBundle = 17;
        static final int TRANSACTION_openOverlay = 12;
        static final int TRANSACTION_setOverlayViewProperties = 19;
        static final int TRANSACTION_startScroll = 6;
        static final int TRANSACTION_stateChange = 8;
        static final int TRANSACTION_windowAttached = 4;
        static final int TRANSACTION_windowAttached2 = 3;
        static final int TRANSACTION_windowDetached = 5;

        public static class Proxy implements ILauncherOverlay {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void bindWidgetDragCallbacks(ILauncherWidgetDragCallback iLauncherWidgetDragCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iLauncherWidgetDragCallback);
                    this.mRemote.transact(18, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void closeOverlay(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void endScroll() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ILauncherOverlay.DESCRIPTOR;
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public boolean isOverlayOpened() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void navigateToDefaultPage() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    this.mRemote.transact(10, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void onBackPressed() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    this.mRemote.transact(9, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void onFlingVelocity(float f10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    parcelObtain.writeFloat(f10);
                    this.mRemote.transact(23, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void onPause() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    this.mRemote.transact(11, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void onProxyTouch(MotionEvent motionEvent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    a.d(parcelObtain, motionEvent, 0);
                    this.mRemote.transact(22, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void onRemoteTransitionEnd(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    a.d(parcelObtain, bundle, 0);
                    this.mRemote.transact(21, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void onRemoteTransitionStart(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    a.d(parcelObtain, bundle, 0);
                    this.mRemote.transact(20, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void onResume() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    this.mRemote.transact(13, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void onScroll(float f10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    parcelObtain.writeFloat(f10);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void onStart() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    this.mRemote.transact(14, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void onStop() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    this.mRemote.transact(15, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public Bundle onWidgetDragBundle(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    a.d(parcelObtain, bundle, 0);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) a.c(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void openOverlay(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(12, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void setOverlayViewProperties(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    a.d(parcelObtain, bundle, 0);
                    this.mRemote.transact(19, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void startScroll() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void stateChange(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(8, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void windowAttached(WindowManager.LayoutParams layoutParams, ILauncherOverlayCallback iLauncherOverlayCallback, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    a.d(parcelObtain, layoutParams, 0);
                    parcelObtain.writeStrongInterface(iLauncherOverlayCallback);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void windowAttached2(Bundle bundle, ILauncherOverlayCallback iLauncherOverlayCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    a.d(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iLauncherOverlayCallback);
                    this.mRemote.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
            public void windowDetached(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILauncherOverlay.DESCRIPTOR);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(5, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ILauncherOverlay.DESCRIPTOR);
        }

        public static ILauncherOverlay asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ILauncherOverlay.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILauncherOverlay)) ? new Proxy(iBinder) : (ILauncherOverlay) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ILauncherOverlay.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ILauncherOverlay.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    onScroll(parcel.readFloat());
                    return true;
                case 2:
                    closeOverlay(parcel.readInt());
                    return true;
                case 3:
                    windowAttached2((Bundle) a.c(parcel, Bundle.CREATOR), ILauncherOverlayCallback.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case 4:
                    windowAttached((WindowManager.LayoutParams) a.c(parcel, WindowManager.LayoutParams.CREATOR), ILauncherOverlayCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 5:
                    windowDetached(parcel.readInt() != 0);
                    return true;
                case 6:
                    startScroll();
                    return true;
                case 7:
                    endScroll();
                    return true;
                case 8:
                    stateChange(parcel.readInt());
                    return true;
                case 9:
                    onBackPressed();
                    return true;
                case 10:
                    navigateToDefaultPage();
                    return true;
                case 11:
                    onPause();
                    return true;
                case 12:
                    openOverlay(parcel.readInt());
                    return true;
                case 13:
                    onResume();
                    return true;
                case 14:
                    onStart();
                    return true;
                case 15:
                    onStop();
                    return true;
                case 16:
                    boolean zIsOverlayOpened = isOverlayOpened();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsOverlayOpened ? 1 : 0);
                    return true;
                case 17:
                    Bundle bundleOnWidgetDragBundle = onWidgetDragBundle((Bundle) a.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    a.d(parcel2, bundleOnWidgetDragBundle, 1);
                    return true;
                case 18:
                    bindWidgetDragCallbacks(ILauncherWidgetDragCallback.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case 19:
                    setOverlayViewProperties((Bundle) a.c(parcel, Bundle.CREATOR));
                    return true;
                case 20:
                    onRemoteTransitionStart((Bundle) a.c(parcel, Bundle.CREATOR));
                    return true;
                case 21:
                    onRemoteTransitionEnd((Bundle) a.c(parcel, Bundle.CREATOR));
                    return true;
                case 22:
                    onProxyTouch((MotionEvent) a.c(parcel, MotionEvent.CREATOR));
                    return true;
                case 23:
                    onFlingVelocity(parcel.readFloat());
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    public static class a {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void bindWidgetDragCallbacks(ILauncherWidgetDragCallback iLauncherWidgetDragCallback) throws RemoteException;

    void closeOverlay(int i10) throws RemoteException;

    void endScroll() throws RemoteException;

    boolean isOverlayOpened() throws RemoteException;

    void navigateToDefaultPage() throws RemoteException;

    void onBackPressed() throws RemoteException;

    void onFlingVelocity(float f10) throws RemoteException;

    void onPause() throws RemoteException;

    void onProxyTouch(MotionEvent motionEvent) throws RemoteException;

    void onRemoteTransitionEnd(Bundle bundle) throws RemoteException;

    void onRemoteTransitionStart(Bundle bundle) throws RemoteException;

    void onResume() throws RemoteException;

    void onScroll(float f10) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;

    Bundle onWidgetDragBundle(Bundle bundle) throws RemoteException;

    void openOverlay(int i10) throws RemoteException;

    void setOverlayViewProperties(Bundle bundle) throws RemoteException;

    void startScroll() throws RemoteException;

    void stateChange(int i10) throws RemoteException;

    void windowAttached(WindowManager.LayoutParams layoutParams, ILauncherOverlayCallback iLauncherOverlayCallback, int i10) throws RemoteException;

    void windowAttached2(Bundle bundle, ILauncherOverlayCallback iLauncherOverlayCallback) throws RemoteException;

    void windowDetached(boolean z10) throws RemoteException;
}
