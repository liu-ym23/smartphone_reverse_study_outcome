package C5;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.deepbinder.core.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\f\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"LC5/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "what", "Landroid/os/IBinder;", "delegate", "LC5/a$b;", "extraCheck", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;Landroid/os/IBinder;LC5/a$b;)Landroid/os/IBinder;", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!¨\u0006\""}, d2 = {"LC5/a$a;", "Landroid/os/Binder;", "Landroid/content/Context;", "context", "", "what", "Landroid/os/IBinder;", "delegate", "LC5/a$b;", "extraCheck", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/IBinder;LC5/a$b;)V", "getInterfaceDescriptor", "()Ljava/lang/String;", "", "pingBinder", "()Z", "isBinderAlive", "descriptor", "Landroid/os/IInterface;", "queryLocalInterface", "(Ljava/lang/String;)Landroid/os/IInterface;", "", "code", "Landroid/os/Parcel;", "data", Constants.PARAM_REPLY, "flags", "onTransact", "(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z", "Landroid/content/Context;", "Ljava/lang/String;", "Landroid/os/IBinder;", "LC5/a$b;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: C5.a$a, reason: collision with other inner class name */
    public static final class BinderC0017a extends Binder {
        private final Context context;
        private final IBinder delegate;
        private final b extraCheck;
        private final String what;

        public BinderC0017a(Context context, String what, IBinder delegate, b bVar) {
            p.i(context, "context");
            p.i(what, "what");
            p.i(delegate, "delegate");
            this.context = context;
            this.what = what;
            this.delegate = delegate;
        }

        @Override // android.os.Binder, android.os.IBinder
        public String getInterfaceDescriptor() {
            return this.delegate.getInterfaceDescriptor();
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean isBinderAlive() {
            return this.delegate.isBinderAlive();
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            p.i(data, "data");
            d.INSTANCE.g(this.context, this.what);
            return this.delegate.transact(code, data, reply, flags);
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean pingBinder() {
            return this.delegate.pingBinder();
        }

        @Override // android.os.Binder, android.os.IBinder
        public IInterface queryLocalInterface(String descriptor) {
            p.i(descriptor, "descriptor");
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"LC5/a$b;", "", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
    }

    public static final IBinder a(Context context, String what, IBinder delegate) {
        p.i(context, "context");
        p.i(what, "what");
        p.i(delegate, "delegate");
        return c(context, what, delegate, null, 8, null);
    }

    public static final IBinder b(Context context, String what, IBinder delegate, b extraCheck) {
        p.i(context, "context");
        p.i(what, "what");
        p.i(delegate, "delegate");
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        return new BinderC0017a(applicationContext, what, delegate, extraCheck);
    }

    public static /* synthetic */ IBinder c(Context context, String str, IBinder iBinder, b bVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            bVar = null;
        }
        return b(context, str, iBinder, bVar);
    }
}
