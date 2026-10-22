package c8;

import Y8.t;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.zyql.agentfront.bean.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\b\u0004*\u0001V\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH$¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH$¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0013H$¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b \u0010\u000bJ\u0015\u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u000bJ\u0017\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"H\u0004¢\u0006\u0004\b$\u0010%J#\u0010(\u001a\u00020\t2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t0&H\u0004¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\tH\u0014¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\tH\u0014¢\u0006\u0004\b,\u0010+J#\u0010.\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u001bH\u0004¢\u0006\u0004\b0\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R$\u0010:\u001a\u0004\u0018\u00018\u00008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u00109R\"\u0010B\u001a\u00020;8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010H\u001a\u0004\u0018\u00010\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010\u001aR\u0016\u0010I\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010=R\u0016\u0010K\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010MR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\"0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010PR\"\u0010U\u001a\u00020\u001b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010J\u001a\u0004\bR\u0010\u001d\"\u0004\bS\u0010TR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010W¨\u0006Y"}, d2 = {"Lc8/b;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lc8/d;", "retryConfig", "<init>", "(Lc8/d;)V", "Landroid/content/Context;", "context", "LY8/t;", "v", "(Landroid/content/Context;)V", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "()J", "", "n", "()Ljava/lang/String;", "o", "Landroid/os/IBinder;", "binder", "f", "(Landroid/os/IBinder;)Ljava/lang/Object;", "Lc8/c;", "listener", "z", "(Lc8/c;)V", "", "r", "()Z", "m", "()Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lcom/zyql/agentfront/bean/Message;", "message", "e", "(Lcom/zyql/agentfront/bean/Message;)V", "Lkotlin/Function1;", "action", "u", "(Lp9/l;)V", "s", "()V", "t", "reason", "p", "(Landroid/content/Context;Ljava/lang/String;)V", "q", Const.INTENT_KEY_APIKEY, "Lc8/d;", "l", "()Lc8/d;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "getServiceInterface", "y", "(Ljava/lang/Object;)V", "serviceInterface", "", "c", "I", "getConnectionStateValue", "()I", "x", "(I)V", "connectionStateValue", Const.INTENT_KEY_UMID, "Lc8/c;", "k", "()Lc8/c;", "setClientStateListener", "clientStateListener", "retryCount", "Z", "isManualUnbind", "Landroid/os/Handler;", "Landroid/os/Handler;", "retryHandler", "", "Ljava/util/List;", "pendingMessages", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "setClientDestroyed", "(Z)V", "clientDestroyed", "c8/b$a", "Lc8/b$a;", "serviceConnection", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: c8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1504b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final RetryConfig retryConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public T serviceInterface;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int connectionStateValue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1505c clientStateListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int retryCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean isManualUnbind;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Handler retryHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final List<Message> pendingMessages;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public volatile boolean clientDestroyed;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final a serviceConnection;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"c8/b$a", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: c8.b$a */
    public static final class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1504b<T> f15489a;

        public a(AbstractC1504b<T> abstractC1504b) {
            this.f15489a = abstractC1504b;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (this.f15489a.getClientDestroyed() || this.f15489a.isManualUnbind) {
                return;
            }
            AbstractC1504b<T> abstractC1504b = this.f15489a;
            p.f(service);
            abstractC1504b.y(abstractC1504b.f(service));
            this.f15489a.x(2);
            this.f15489a.retryCount = 0;
            this.f15489a.s();
            InterfaceC1505c clientStateListener = this.f15489a.getClientStateListener();
            if (clientStateListener != null) {
                clientStateListener.onConnected();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            this.f15489a.y(null);
            this.f15489a.x(0);
            this.f15489a.t();
            InterfaceC1505c clientStateListener = this.f15489a.getClientStateListener();
            if (clientStateListener != null) {
                clientStateListener.onDisconnected();
            }
            if (this.f15489a.isManualUnbind || !this.f15489a.getRetryConfig().getRetryOnDisconnect() || this.f15489a.getClientDestroyed()) {
                return;
            }
            this.f15489a.v(null);
        }
    }

    public AbstractC1504b(RetryConfig retryConfig) {
        p.i(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        this.retryHandler = new Handler(Looper.getMainLooper());
        this.pendingMessages = new ArrayList();
        this.serviceConnection = new a(this);
    }

    public static final void w(AbstractC1504b abstractC1504b, Context context) {
        if (abstractC1504b.clientDestroyed || abstractC1504b.isManualUnbind || context == null) {
            return;
        }
        abstractC1504b.h(context);
    }

    public final void e(Message message) {
        p.i(message, "message");
        synchronized (this.pendingMessages) {
            this.pendingMessages.add(message);
        }
    }

    public abstract T f(IBinder binder);

    public final long g() {
        return Math.min((long) (this.retryConfig.getInitialDelayMs() * Math.pow(this.retryConfig.getBackoffMultiplier(), this.retryCount - 1)), this.retryConfig.getMaxDelayMs());
    }

    public final void h(Context context) {
        p.i(context, "context");
        if (r() || this.connectionStateValue == 1) {
            return;
        }
        this.isManualUnbind = false;
        this.connectionStateValue = 1;
        Intent intent = new Intent(n());
        intent.setPackage(o());
        try {
            if (context.bindService(intent, this.serviceConnection, 1)) {
                return;
            }
            p(context, "Failed to bind service: service not found");
        } catch (SecurityException e10) {
            p(context, "SecurityException: " + e10.getMessage());
        } catch (Exception e11) {
            p(context, "Exception: " + e11.getMessage());
        }
    }

    public final void i(Context context) {
        p.i(context, "context");
        this.isManualUnbind = true;
        this.retryHandler.removeCallbacksAndMessages(null);
        this.retryCount = 0;
        if (this.connectionStateValue != 0) {
            this.connectionStateValue = 3;
            try {
                context.unbindService(this.serviceConnection);
            } catch (Exception unused) {
            }
        }
        this.serviceInterface = null;
        this.connectionStateValue = 0;
        this.pendingMessages.clear();
    }

    /* renamed from: j, reason: from getter */
    public final boolean getClientDestroyed() {
        return this.clientDestroyed;
    }

    /* renamed from: k, reason: from getter */
    public final InterfaceC1505c getClientStateListener() {
        return this.clientStateListener;
    }

    /* renamed from: l, reason: from getter */
    public final RetryConfig getRetryConfig() {
        return this.retryConfig;
    }

    public final T m() {
        return this.serviceInterface;
    }

    public abstract String n();

    public abstract String o();

    public void p(Context context, String reason) {
        this.connectionStateValue = 0;
        InterfaceC1505c interfaceC1505c = this.clientStateListener;
        if (interfaceC1505c != null) {
            interfaceC1505c.onBindFailed(reason);
        }
        if (this.isManualUnbind || this.retryCount >= this.retryConfig.getMaxRetryCount() || this.clientDestroyed) {
            return;
        }
        v(context);
    }

    public final boolean q() {
        return this.clientDestroyed;
    }

    public final boolean r() {
        return this.connectionStateValue == 2 && this.serviceInterface != null;
    }

    public abstract void s();

    public abstract void t();

    public final void u(InterfaceC5074l<? super Message, t> action) {
        p.i(action, "action");
        synchronized (this.pendingMessages) {
            Iterator<Message> it = this.pendingMessages.iterator();
            while (it.hasNext()) {
                try {
                    action.invoke(it.next());
                    it.remove();
                } catch (Exception unused) {
                }
            }
            t tVar = t.f7040a;
        }
    }

    public final void v(final Context context) {
        int i10 = this.retryCount + 1;
        this.retryCount = i10;
        InterfaceC1505c interfaceC1505c = this.clientStateListener;
        if (interfaceC1505c != null) {
            interfaceC1505c.a(i10, this.retryConfig.getMaxRetryCount());
        }
        this.retryHandler.postDelayed(new Runnable() { // from class: c8.a
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC1504b.w(this.f15477a, context);
            }
        }, g());
    }

    public final void x(int i10) {
        this.connectionStateValue = i10;
    }

    public final void y(T t10) {
        this.serviceInterface = t10;
    }

    public final void z(InterfaceC1505c listener) {
        this.clientStateListener = listener;
    }
}
