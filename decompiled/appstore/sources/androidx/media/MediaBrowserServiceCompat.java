package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f3609f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaBrowserServiceImpl f3610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap f3611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f3612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f3613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MediaSessionCompat.Token f3614e;

    public interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(MediaSessionManager$RemoteUserInfo r10, String r11, Bundle r12);

        void notifyChildrenChanged(String r10, Bundle r11);

        IBinder onBind(Intent r10);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token r10);
    }

    public interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String r10, MediaSessionCompat.Token r11, Bundle r12) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String r10, List<MediaBrowserCompat.MediaItem> r11, Bundle r12, Bundle r13) throws RemoteException;
    }

    public class a extends k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f f3615f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f3616g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Bundle f3617h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Bundle f3618i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3619j;

        public a(MediaBrowserServiceCompat r10, Object r11, f r12, String r13, Bundle r14, Bundle r15) {
            this.f3619j = r10;
            this.f3615f = r12;
            this.f3616g = r13;
            this.f3617h = r14;
            this.f3618i = r15;
            super(r11);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        public /* bridge */ /* synthetic */ void d(Object r10) {
            h((List) r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void h(List r10) {
            if (this.f3619j.f3611b.get(this.f3615f.f3631f.asBinder()) == this.f3615f) goto L9;
            if (MediaBrowserServiceCompat.f3609f == false) goto L17;
            Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f3615f.f3626a + " id=" + this.f3616g);
            return;
        L17:
            return;
        L9:
            if ((a() & 1) == 0) goto L15;
            r10 = this.f3619j.b(r10, this.f3617h);
        L15:
            this.f3615f.f3631f.onLoadChildren(this.f3616g, r10, this.f3617h, this.f3618i);     // Catch: RemoteException -> L13
            return;
        L13:
            Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.f3616g + " package=" + this.f3615f.f3626a);
        }
    }

    public class b extends k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f3620f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3621g;

        public b(MediaBrowserServiceCompat r10, Object r11, ResultReceiver r12) {
            this.f3621g = r10;
            this.f3620f = r12;
            super(r11);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        public /* bridge */ /* synthetic */ void d(Object r10) {
            h((MediaBrowserCompat.MediaItem) r10);
        }

        public void h(MediaBrowserCompat.MediaItem r10) {
            if ((a() & 2) == 0) goto L6;
            this.f3620f.send(-1, null);
            return;
        L6:
            Bundle r11 = new Bundle();
            r11.putParcelable("media_item", r10);
            this.f3620f.send(0, r11);
        }
    }

    public class c extends k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f3622f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3623g;

        public c(MediaBrowserServiceCompat r10, Object r11, ResultReceiver r12) {
            this.f3623g = r10;
            this.f3622f = r12;
            super(r11);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        public /* bridge */ /* synthetic */ void d(Object r10) {
            h((List) r10);
        }

        public void h(List r10) {
            if ((a() & 4) != 0) goto L8;
            if (r10 == null) goto L8;
            Bundle r11 = new Bundle();
            r11.putParcelableArray("search_results", (Parcelable[]) r10.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f3622f.send(0, r11);
            return;
        L8:
            this.f3622f.send(-1, null);
        }
    }

    public class d extends k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f3624f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3625g;

        public d(MediaBrowserServiceCompat r10, Object r11, ResultReceiver r12) {
            this.f3625g = r10;
            this.f3624f = r12;
            super(r11);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        public void c(Bundle r10) {
            this.f3624f.send(-1, r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.k
        public /* bridge */ /* synthetic */ void d(Object r10) {
            h((Bundle) r10);
        }

        public void h(Bundle r10) {
            this.f3624f.send(0, r10);
        }
    }

    public static final class e {
    }

    public class f implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaSessionManager$RemoteUserInfo f3629d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f3630e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ServiceCallbacks f3631f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final HashMap f3632g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3633h;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f3634a;

            public a(f r10) {
                this.f3634a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                f r10 = this.f3634a;
                r10.f3633h.f3611b.remove(r10.f3631f.asBinder());
            }
        }

        public f(MediaBrowserServiceCompat r10, String r11, int r12, int r13, Bundle r14, ServiceCallbacks r15) {
            this.f3633h = r10;
            this.f3632g = new HashMap();
            this.f3626a = r11;
            this.f3627b = r12;
            this.f3628c = r13;
            this.f3629d = new MediaSessionManager$RemoteUserInfo(r11, r12, r13);
            this.f3630e = r14;
            this.f3631f = r15;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.f3633h.f3613d.post(new a(this));
        }
    }

    public class g implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f3635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Messenger f3637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3638d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MediaSessionCompat.Token f3639a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g f3640b;

            public a(g r10, MediaSessionCompat.Token r11) {
                this.f3640b = r10;
                this.f3639a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f3640b.f3635a.isEmpty() == true) goto L11;
                IMediaSession r10 = this.f3639a.getExtraBinder();
                if (r10 == null) goto L10;
                Iterator r11 = this.f3640b.f3635a.iterator();
            L8:
                if (r11.hasNext() == false) goto L10;
                androidx.core.app.d.b((Bundle) r11.next(), "extra_session_binder", r10.asBinder());
            L10:
                this.f3640b.f3635a.clear();
            L11:
                MediaBrowserServiceCompatApi21.d(this.f3640b.f3636b, this.f3639a.getToken());
            }
        }

        public class b extends k {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ MediaBrowserServiceCompatApi21.c f3641f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ g f3642g;

            public b(g r10, Object r11, MediaBrowserServiceCompatApi21.c r12) {
                this.f3642g = r10;
                this.f3641f = r12;
                super(r11);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.k
            public /* bridge */ /* synthetic */ void d(Object r10) {
                h((List) r10);
            }

            public void h(List r10) {
                if (r10 == null) goto L7;
                ArrayList r11 = new ArrayList();
                Iterator r12 = r10.iterator();
            L5:
                if (r12.hasNext() == false) goto L8;
                MediaBrowserCompat.MediaItem r13 = (MediaBrowserCompat.MediaItem) r12.next();
                Parcel r14 = Parcel.obtain();
                r13.writeToParcel(r14, 0);
                r11.add(r14);
            L8:
                this.f3641f.b(r11);
                return;
            L7:
                r11 = null;
                goto L8
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f3643a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bundle f3644b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ g f3645c;

            public c(g r10, String r11, Bundle r12) {
                this.f3645c = r10;
                this.f3643a = r11;
                this.f3644b = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<Object> r10 = this.f3645c.f3638d.f3611b.keySet().iterator();
            L4:
                if (r10.hasNext() == false) goto L6;
                IBinder r11 = (IBinder) r10.next();
                f r12 = (f) this.f3645c.f3638d.f3611b.get(r11);
                this.f3645c.c(r12, this.f3643a, this.f3644b);
                goto L4
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MediaSessionManager$RemoteUserInfo f3646a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f3647b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f3648c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ g f3649d;

            public d(g r10, MediaSessionManager$RemoteUserInfo r11, String r12, Bundle r13) {
                this.f3649d = r10;
                this.f3646a = r11;
                this.f3647b = r12;
                this.f3648c = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                int r10 = 0;
            L4:
                if (r10 >= this.f3649d.f3638d.f3611b.size()) goto L9;
                f r11 = (f) this.f3649d.f3638d.f3611b.valueAt(r10);
                if (r11.f3629d.equals(this.f3646a) == false) goto L8;
                this.f3649d.c(r11, this.f3647b, this.f3648c);
            L8:
                r10 = r10 + 1;
                goto L4
            }
        }

        public g(MediaBrowserServiceCompat r10) {
            this.f3638d = r10;
            this.f3635a = new ArrayList();
        }

        public void a(MediaSessionManager$RemoteUserInfo r10, String r11, Bundle r12) {
            this.f3638d.f3613d.post(new d(this, r10, r11, r12));
        }

        public void b(String r10, Bundle r11) {
            this.f3638d.f3613d.post(new c(this, r10, r11));
        }

        public void c(f r10, String r11, Bundle r12) {
            List r13 = (List) r10.f3632g.get(r11);
            if (r13 == null) goto L10;
            Iterator r14 = r13.iterator();
        L6:
            if (r14.hasNext() == false) goto L16;
            androidx.core.util.c r15 = (androidx.core.util.c) r14.next();
            if (androidx.media.a.b(r12, (Bundle) r15.f2647b) == false) goto L6;
            this.f3638d.m(r11, r10, (Bundle) r15.f2647b, r12);
            goto L6
        L16:
            return;
        }

        public void d(String r10, Bundle r11) {
            MediaBrowserServiceCompatApi21.a(this.f3636b, r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String r10, Bundle r11) {
            d(r10, r11);
            b(r10, r11);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent r10) {
            return MediaBrowserServiceCompatApi21.b(this.f3636b, r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.a onGetRoot(String r11, int r12, Bundle r13) {
            if (r13 != null) goto L5;
        L14:
            MediaBrowserServiceCompat r10 = this.f3638d;
            r10.f3612c = new f(r10, r11, -1, r12, r13, null);
            this.f3638d.e(r11, r12, r13);
            this.f3638d.f3612c = null;
            return null;
        L5:
            if (r13.getInt("extra_client_version", 0) == 0) goto L14;
            r13.remove("extra_client_version");
            this.f3637c = new Messenger(this.f3638d.f3613d);
            Bundle r14 = new Bundle();
            r14.putInt("extra_service_version", 2);
            androidx.core.app.d.b(r14, "extra_messenger", this.f3637c.getBinder());
            MediaSessionCompat.Token r15 = this.f3638d.f3614e;
            if (r15 == null) goto L13;
            IMediaSession r16 = r15.getExtraBinder();
            if (r16 != null) goto L11;
            IBinder r17 = null;
        L12:
            androidx.core.app.d.b(r14, "extra_session_binder", r17);
            goto L14
        L11:
            r17 = r16.asBinder();
            goto L12
        L13:
            this.f3635a.add(r14);
            goto L14
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(String r10, MediaBrowserServiceCompatApi21.c r11) {
            b r12 = new b(this, r10, r11);
            this.f3638d.f(r10, r12);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(MediaSessionCompat.Token r10) {
            this.f3638d.f3613d.a(new a(this, r10));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(MediaSessionManager$RemoteUserInfo r10, String r11, Bundle r12) {
            a(r10, r11, r12);
        }
    }

    public class h extends g implements MediaBrowserServiceCompatApi23$ServiceCompatProxy {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3650e;

        public class a extends k {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ MediaBrowserServiceCompatApi21.c f3651f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ h f3652g;

            public a(h r10, Object r11, MediaBrowserServiceCompatApi21.c r12) {
                this.f3652g = r10;
                this.f3651f = r12;
                super(r11);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.k
            public /* bridge */ /* synthetic */ void d(Object r10) {
                h((MediaBrowserCompat.MediaItem) r10);
            }

            public void h(MediaBrowserCompat.MediaItem r10) {
                if (r10 != null) goto L4;
                this.f3651f.b(null);
                return;
            L4:
                Parcel r11 = Parcel.obtain();
                r10.writeToParcel(r11, 0);
                this.f3651f.b(r11);
            }
        }

        public h(MediaBrowserServiceCompat r10) {
            this.f3650e = r10;
            super(r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy
        public void onLoadItem(String r10, MediaBrowserServiceCompatApi21.c r11) {
            a r12 = new a(this, r10, r11);
            this.f3650e.h(r10, r12);
        }
    }

    public class i extends h implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3653f;

        public class a extends k {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ MediaBrowserServiceCompatApi26.b f3654f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ i f3655g;

            public a(i r10, Object r11, MediaBrowserServiceCompatApi26.b r12) {
                this.f3655g = r10;
                this.f3654f = r12;
                super(r11);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.k
            public /* bridge */ /* synthetic */ void d(Object r10) {
                h((List) r10);
            }

            public void h(List r10) {
                if (r10 == null) goto L7;
                ArrayList r11 = new ArrayList();
                Iterator r12 = r10.iterator();
            L5:
                if (r12.hasNext() == false) goto L8;
                MediaBrowserCompat.MediaItem r13 = (MediaBrowserCompat.MediaItem) r12.next();
                Parcel r14 = Parcel.obtain();
                r13.writeToParcel(r14, 0);
                r11.add(r14);
            L8:
                this.f3654f.b(r11, a());
                return;
            L7:
                r11 = null;
                goto L8
            }
        }

        public i(MediaBrowserServiceCompat r10) {
            this.f3653f = r10;
            super(r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void d(String r10, Bundle r11) {
            if (r11 == null) goto L4;
            MediaBrowserServiceCompatApi26.c(this.f3636b, r10, r11);
            return;
        L4:
            super.d(r10, r11);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            f r10 = this.f3653f.f3612c;
            if (r10 == null) goto L10;
            if (r10.f3630e != null) goto L8;
            return null;
        L8:
            return new Bundle(this.f3653f.f3612c.f3630e);
        L10:
            return MediaBrowserServiceCompatApi26.b(this.f3636b);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r10 = MediaBrowserServiceCompatApi26.a(this.f3653f, this);
            this.f3636b = r10;
            MediaBrowserServiceCompatApi21.c(r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(String r10, MediaBrowserServiceCompatApi26.b r11, Bundle r12) {
            a r13 = new a(this, r10, r11);
            this.f3653f.g(r10, r13, r12);
        }
    }

    public class j extends i {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3656g;

        public j(MediaBrowserServiceCompat r10) {
            this.f3656g = r10;
            super(r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
            f r10 = this.f3656g.f3612c;
            if (r10 == null) goto L7;
            return r10.f3629d;
        L7:
            return new MediaSessionManager$RemoteUserInfo(((MediaBrowserService) this.f3636b).getCurrentBrowserInfo());
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f3657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3661e;

        public k(Object r10) {
            this.f3657a = r10;
        }

        public int a() {
            return this.f3661e;
        }

        public boolean b() {
            if (this.f3658b == false) goto L5;
        L10:
            return true;
        L5:
            if (this.f3659c == true) goto L10;
            if (this.f3660d == true) goto L10;
            return false;
        }

        public void c(Bundle r10) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f3657a);
        }

        public abstract void d(Object r10);

        public void e(Bundle r10) {
            if (this.f3659c == true) goto L9;
            if (this.f3660d == true) goto L9;
            this.f3660d = true;
            c(r10);
            return;
        L9:
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f3657a);
        }

        public void f(Object r10) {
            if (this.f3659c == true) goto L9;
            if (this.f3660d == true) goto L9;
            this.f3659c = true;
            d(r10);
            return;
        L9:
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f3657a);
        }

        public void g(int r10) {
            this.f3661e = r10;
        }
    }

    public class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3662a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceCallbacks f3663a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f3664b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f3665c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f3666d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Bundle f3667e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ l f3668f;

            public a(l r10, ServiceCallbacks r11, String r12, int r13, int r14, Bundle r15) {
                this.f3668f = r10;
                this.f3663a = r11;
                this.f3664b = r12;
                this.f3665c = r13;
                this.f3666d = r14;
                this.f3667e = r15;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3668f.f3662a.f3611b.remove(this.f3663a.asBinder());
                f r10 = new f(this.f3668f.f3662a, this.f3664b, this.f3665c, this.f3666d, this.f3667e, this.f3663a);
                MediaBrowserServiceCompat r11 = this.f3668f.f3662a;
                r11.f3612c = r10;
                r11.e(this.f3664b, this.f3666d, this.f3667e);
                this.f3668f.f3662a.f3612c = null;
                Log.i("MBServiceCompat", "No root for client " + this.f3664b + " from service " + getClass().getName());
                this.f3663a.onConnectFailed();     // Catch: RemoteException -> L5
                return;
            L5:
                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f3664b);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceCallbacks f3669a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ l f3670b;

            public b(l r10, ServiceCallbacks r11) {
                this.f3670b = r10;
                this.f3669a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder r10 = this.f3669a.asBinder();
                f r11 = (f) this.f3670b.f3662a.f3611b.remove(r10);
                if (r11 == null) goto L6;
                r11.f3631f.asBinder().unlinkToDeath(r11, 0);
                return;
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceCallbacks f3671a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f3672b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IBinder f3673c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Bundle f3674d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ l f3675e;

            public c(l r10, ServiceCallbacks r11, String r12, IBinder r13, Bundle r14) {
                this.f3675e = r10;
                this.f3671a = r11;
                this.f3672b = r12;
                this.f3673c = r13;
                this.f3674d = r14;
            }

            @Override // java.lang.Runnable
            public void run() {
                f r10 = (f) this.f3675e.f3662a.f3611b.get(this.f3671a.asBinder());
                if (r10 != null) goto L6;
                Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.f3672b);
                return;
            L6:
                this.f3675e.f3662a.a(this.f3672b, r10, this.f3673c, this.f3674d);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceCallbacks f3676a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f3677b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IBinder f3678c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ l f3679d;

            public d(l r10, ServiceCallbacks r11, String r12, IBinder r13) {
                this.f3679d = r10;
                this.f3676a = r11;
                this.f3677b = r12;
                this.f3678c = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                f r10 = (f) this.f3679d.f3662a.f3611b.get(this.f3676a.asBinder());
                if (r10 != null) goto L7;
                Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.f3677b);
                return;
            L7:
                if (this.f3679d.f3662a.p(this.f3677b, r10, this.f3678c) == true) goto L10;
                Log.w("MBServiceCompat", "removeSubscription called for " + this.f3677b + " which is not subscribed");
                return;
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceCallbacks f3680a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f3681b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f3682c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ l f3683d;

            public e(l r10, ServiceCallbacks r11, String r12, ResultReceiver r13) {
                this.f3683d = r10;
                this.f3680a = r11;
                this.f3681b = r12;
                this.f3682c = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                f r10 = (f) this.f3683d.f3662a.f3611b.get(this.f3680a.asBinder());
                if (r10 != null) goto L6;
                Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f3681b);
                return;
            L6:
                this.f3683d.f3662a.n(this.f3681b, r10, this.f3682c);
            }
        }

        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceCallbacks f3684a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f3685b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f3686c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f3687d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Bundle f3688e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ l f3689f;

            public f(l r10, ServiceCallbacks r11, String r12, int r13, int r14, Bundle r15) {
                this.f3689f = r10;
                this.f3684a = r11;
                this.f3685b = r12;
                this.f3686c = r13;
                this.f3687d = r14;
                this.f3688e = r15;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder r10 = this.f3684a.asBinder();
                this.f3689f.f3662a.f3611b.remove(r10);
                f r11 = new f(this.f3689f.f3662a, this.f3685b, this.f3686c, this.f3687d, this.f3688e, this.f3684a);
                this.f3689f.f3662a.f3611b.put(r10, r11);
                r10.linkToDeath(r11, 0);     // Catch: RemoteException -> L5
                return;
            L5:
                Log.w("MBServiceCompat", "IBinder is already dead.");
            }
        }

        public class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceCallbacks f3690a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ l f3691b;

            public g(l r10, ServiceCallbacks r11) {
                this.f3691b = r10;
                this.f3690a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder r10 = this.f3690a.asBinder();
                f r11 = (f) this.f3691b.f3662a.f3611b.remove(r10);
                if (r11 == null) goto L6;
                r10.unlinkToDeath(r11, 0);
                return;
            }
        }

        public class h implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceCallbacks f3692a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f3693b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f3694c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f3695d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ l f3696e;

            public h(l r10, ServiceCallbacks r11, String r12, Bundle r13, ResultReceiver r14) {
                this.f3696e = r10;
                this.f3692a = r11;
                this.f3693b = r12;
                this.f3694c = r13;
                this.f3695d = r14;
            }

            @Override // java.lang.Runnable
            public void run() {
                f r10 = (f) this.f3696e.f3662a.f3611b.get(this.f3692a.asBinder());
                if (r10 != null) goto L6;
                Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f3693b);
                return;
            L6:
                this.f3696e.f3662a.o(this.f3693b, this.f3694c, r10, this.f3695d);
            }
        }

        public class i implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ServiceCallbacks f3697a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f3698b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f3699c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f3700d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ l f3701e;

            public i(l r10, ServiceCallbacks r11, String r12, Bundle r13, ResultReceiver r14) {
                this.f3701e = r10;
                this.f3697a = r11;
                this.f3698b = r12;
                this.f3699c = r13;
                this.f3700d = r14;
            }

            @Override // java.lang.Runnable
            public void run() {
                f r10 = (f) this.f3701e.f3662a.f3611b.get(this.f3697a.asBinder());
                if (r10 != null) goto L6;
                Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f3698b + ", extras=" + this.f3699c);
                return;
            L6:
                this.f3701e.f3662a.l(this.f3698b, this.f3699c, r10, this.f3700d);
            }
        }

        public l(MediaBrowserServiceCompat r10) {
            this.f3662a = r10;
        }

        public void a(String r10, IBinder r11, Bundle r12, ServiceCallbacks r13) {
            this.f3662a.f3613d.a(new c(this, r13, r10, r11, r12));
        }

        public void b(String r10, int r11, int r12, Bundle r13, ServiceCallbacks r14) {
            if (this.f3662a.c(r10, r12) == false) goto L7;
            this.f3662a.f3613d.a(new a(this, r14, r10, r11, r12, r13));
            return;
        L7:
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + r12 + " package=" + r10);
        }

        public void c(ServiceCallbacks r10) {
            this.f3662a.f3613d.a(new b(this, r10));
        }

        public void d(String r10, ResultReceiver r11, ServiceCallbacks r12) {
            if (TextUtils.isEmpty(r10) == true) goto L8;
            if (r11 == null) goto L9;
            this.f3662a.f3613d.a(new e(this, r12, r10, r11));
            return;
        L9:
            return;
        }

        public void e(ServiceCallbacks r10, String r11, int r12, int r13, Bundle r14) {
            this.f3662a.f3613d.a(new f(this, r10, r11, r12, r13, r14));
        }

        public void f(String r10, IBinder r11, ServiceCallbacks r12) {
            this.f3662a.f3613d.a(new d(this, r12, r10, r11));
        }

        public void g(String r10, Bundle r11, ResultReceiver r12, ServiceCallbacks r13) {
            if (TextUtils.isEmpty(r10) == true) goto L8;
            if (r12 == null) goto L9;
            this.f3662a.f3613d.a(new h(this, r13, r10, r11, r12));
            return;
        L9:
            return;
        }

        public void h(String r10, Bundle r11, ResultReceiver r12, ServiceCallbacks r13) {
            if (TextUtils.isEmpty(r10) == true) goto L8;
            if (r12 == null) goto L9;
            this.f3662a.f3613d.a(new i(this, r13, r10, r11, r12));
            return;
        L9:
            return;
        }

        public void i(ServiceCallbacks r10) {
            this.f3662a.f3613d.a(new g(this, r10));
        }
    }

    public static class m implements ServiceCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Messenger f3702a;

        public m(Messenger r10) {
            this.f3702a = r10;
        }

        public final void a(int r10, Bundle r11) {
            Message r12 = Message.obtain();
            r12.what = r10;
            r12.arg1 = 2;
            r12.setData(r11);
            this.f3702a.send(r12);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            return this.f3702a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(String r10, MediaSessionCompat.Token r11, Bundle r12) {
            if (r12 != null) goto L4;
            r12 = new Bundle();
        L4:
            r12.putInt("extra_service_version", 2);
            Bundle r13 = new Bundle();
            r13.putString("data_media_item_id", r10);
            r13.putParcelable("data_media_session_token", r11);
            r13.putBundle("data_root_hints", r12);
            a(1, r13);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() {
            a(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(String r10, List r11, Bundle r12, Bundle r13) {
            Bundle r14 = new Bundle();
            r14.putString("data_media_item_id", r10);
            r14.putBundle("data_options", r12);
            r14.putBundle("data_notify_children_changed_options", r13);
            if (r11 != null) goto L5;
        L9:
            a(3, r14);
            return;
        L5:
            if ((r11 instanceof ArrayList) == false) goto L7;
            ArrayList<? extends Parcelable> r15 = (ArrayList) r11;
        L8:
            r14.putParcelableArrayList("data_media_item_list", r15);
            goto L9
        L7:
            r15 = new ArrayList(r11);
            goto L8
        }
    }

    public final class n extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f3703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f3704b;

        public n(MediaBrowserServiceCompat r10) {
            this.f3704b = r10;
            this.f3703a = new l(r10);
        }

        public void a(Runnable r10) {
            if (Thread.currentThread() != getLooper().getThread()) goto L5;
            r10.run();
            return;
        L5:
            post(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            Bundle r11 = r10.getData();
            switch(r10.what) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                case 9: goto L5;
                default: goto L4;
            };
        L4:
            Log.w("MBServiceCompat", "Unhandled message: " + r10 + "\n  Service version: 2\n  Client version: " + r10.arg1);
            return;
        L5:
            Bundle r12 = r11.getBundle("data_custom_action_extras");
            MediaSessionCompat.ensureClassLoader(r12);
            this.f3703a.h(r11.getString("data_custom_action"), r12, (ResultReceiver) r11.getParcelable("data_result_receiver"), new m(r10.replyTo));
            return;
        L6:
            Bundle r13 = r11.getBundle("data_search_extras");
            MediaSessionCompat.ensureClassLoader(r13);
            this.f3703a.g(r11.getString("data_search_query"), r13, (ResultReceiver) r11.getParcelable("data_result_receiver"), new m(r10.replyTo));
            return;
        L7:
            this.f3703a.i(new m(r10.replyTo));
            return;
        L8:
            Bundle r14 = r11.getBundle("data_root_hints");
            MediaSessionCompat.ensureClassLoader(r14);
            this.f3703a.e(new m(r10.replyTo), r11.getString("data_package_name"), r11.getInt("data_calling_pid"), r11.getInt("data_calling_uid"), r14);
            return;
        L9:
            this.f3703a.d(r11.getString("data_media_item_id"), (ResultReceiver) r11.getParcelable("data_result_receiver"), new m(r10.replyTo));
            return;
        L10:
            this.f3703a.f(r11.getString("data_media_item_id"), androidx.core.app.d.a(r11, "data_callback_token"), new m(r10.replyTo));
            return;
        L11:
            Bundle r15 = r11.getBundle("data_options");
            MediaSessionCompat.ensureClassLoader(r15);
            this.f3703a.a(r11.getString("data_media_item_id"), androidx.core.app.d.a(r11, "data_callback_token"), r15, new m(r10.replyTo));
            return;
        L12:
            this.f3703a.c(new m(r10.replyTo));
            return;
        L13:
            Bundle r16 = r11.getBundle("data_root_hints");
            MediaSessionCompat.ensureClassLoader(r16);
            this.f3703a.b(r11.getString("data_package_name"), r11.getInt("data_calling_pid"), r11.getInt("data_calling_uid"), r16, new m(r10.replyTo));
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r10, long r11) {
            Bundle r12 = r10.getData();
            r12.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            r12.putInt("data_calling_uid", Binder.getCallingUid());
            r12.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(r10, r11);
        }
    }

    static {
        f3609f = Log.isLoggable("MBServiceCompat", 3);
    }

    public MediaBrowserServiceCompat() {
        this.f3611b = new ArrayMap();
        this.f3613d = new n(this);
    }

    public void a(String r10, f r11, IBinder r12, Bundle r13) {
        List r14 = (List) r11.f3632g.get(r10);
        if (r14 != null) goto L5;
        r14 = new ArrayList();
    L5:
        Iterator r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L13;
        androidx.core.util.c r16 = (androidx.core.util.c) r15.next();
        if (r12 != r16.f2646a) goto L7;
        if (androidx.media.a.a(r13, (Bundle) r16.f2647b) == false) goto L7;
        return;
    L13:
        r14.add(new androidx.core.util.c(r12, r13));
        r11.f3632g.put(r10, r14);
        m(r10, r11, r13, null);
        this.f3612c = r11;
        j(r10, r13);
        this.f3612c = null;
    }

    public List b(List r10, Bundle r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r12 = r11.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int r13 = r11.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (r12 != (-1)) goto L9;
        if (r13 != (-1)) goto L9;
        return r10;
    L9:
        int r14 = r13 * r12;
        int r15 = r14 + r13;
        if (r12 < 0) goto L22;
        if (r13 < 1) goto L22;
        if (r14 >= r10.size()) goto L22;
        if (r15 <= r10.size()) goto L20;
        r15 = r10.size();
    L20:
        return r10.subList(r14, r15);
    L22:
        return Collections.emptyList();
    }

    public boolean c(String r10, int r11) {
        if (r10 != null) goto L5;
        return false;
    L5:
        String[] r12 = getPackageManager().getPackagesForUid(r11);
        int r13 = r12.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L12;
        if (r12[r14].equals(r10) == true) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public void d(String r10, Bundle r11, k r12) {
        r12.e(null);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor r10, PrintWriter r11, String[] r12) {
    }

    public abstract e e(String r10, int r11, Bundle r12);

    public abstract void f(String r10, k r11);

    public void g(String r10, k r11, Bundle r12) {
        r11.g(1);
        f(r10, r11);
    }

    public void h(String r10, k r11) {
        r11.g(2);
        r11.f(null);
    }

    public void i(String r10, Bundle r11, k r12) {
        r12.g(4);
        r12.f(null);
    }

    public void j(String r10, Bundle r11) {
    }

    public void k(String r10) {
    }

    public void l(String r10, Bundle r11, f r12, ResultReceiver r13) {
        d r14 = new d(this, r10, r13);
        this.f3612c = r12;
        d(r10, r11, r14);
        this.f3612c = null;
        if (r14.b() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + r10 + " extras=" + r11);
    }

    public void m(String r10, f r11, Bundle r12, Bundle r13) {
        a r14 = new a(this, r10, r11, r10, r12, r13);
        this.f3612c = r11;
        if (r12 != null) goto L5;
        f(r10, r14);
    L6:
        this.f3612c = null;
        if (r14.b() == false) goto L10;
        return;
    L10:
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + r11.f3626a + " id=" + r10);
    L5:
        g(r10, r14, r12);
        goto L6
    }

    public void n(String r10, f r11, ResultReceiver r12) {
        b r13 = new b(this, r10, r12);
        this.f3612c = r11;
        h(r10, r13);
        this.f3612c = null;
        if (r13.b() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + r10);
    }

    public void o(String r10, Bundle r11, f r12, ResultReceiver r13) {
        c r14 = new c(this, r10, r13);
        this.f3612c = r12;
        i(r10, r11, r14);
        this.f3612c = null;
        if (r14.b() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + r10);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return this.f3610a.onBind(r10);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        j r10 = new j(this);
        this.f3610a = r10;
        r10.onCreate();
    }

    public boolean p(String r10, f r11, IBinder r12) {
        boolean r13 = false;
        if (r12 == null) goto L5;
        List r14 = (List) r11.f3632g.get(r10);     // Catch: Throwable -> L9
        if (r14 != null) goto L13;
    L7:
        this.f3612c = r11;
        k(r10);
        this.f3612c = null;
        return r13;
    L13:
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L9
    L15:
        if (r15.hasNext() == false) goto L20;
        if (r12 != ((androidx.core.util.c) r15.next()).f2646a) goto L15;
        r15.remove();     // Catch: Throwable -> L9
        r13 = true;
        goto L15
    L20:
        if (r14.size() != 0) goto L7;
        r11.f3632g.remove(r10);     // Catch: Throwable -> L9
        goto L7
    L5:
        if (r11.f3632g.remove(r10) == null) goto L7;
        r13 = true;
    L9:
        th = move-exception;
        this.f3612c = r11;
        k(r10);
        this.f3612c = null;
        throw th;
    }
}
