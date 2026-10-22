package B1;

import B1.c;
import android.content.Context;
import android.util.DisplayMetrics;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011¨\u0006\u0012"}, d2 = {"LB1/d;", "LB1/h;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LB1/g;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/content/Context;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    public d(Context context) {
        this.context = context;
    }

    @Override // B1.h
    public Object a(InterfaceC4014c<? super Size> interfaceC4014c) {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        c.a aVarA = a.a(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new Size(aVarA, aVarA);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof d) && p.d(this.context, ((d) other).context);
    }

    public int hashCode() {
        return this.context.hashCode();
    }
}
