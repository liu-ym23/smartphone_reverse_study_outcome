package B1;

import B1.c;
import Ua.InterfaceC1066l;
import Y8.t;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ)\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0017\u001a\u00020\u0016*\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0003"}, d2 = {"LB1/j;", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "LB1/h;", "LB1/g;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "getSize", "()LB1/g;", "LB1/c;", "getWidth", "()LB1/c;", "getHeight", "", "paramSize", "viewSize", "paddingSize", "c", "(III)LB1/c;", "Landroid/view/ViewTreeObserver;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "victim", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/view/ViewTreeObserver;Landroid/view/ViewTreeObserver$OnPreDrawListener;)V", "getView", "()Landroid/view/View;", "view", "", "e", "()Z", "subtractPadding", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface j<T extends View> extends h {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements InterfaceC5074l<Throwable, t> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j<T> f1426a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f1427b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f1428c;

        public a(j<T> jVar, ViewTreeObserver viewTreeObserver, b bVar) {
            this.f1426a = jVar;
            this.f1427b = viewTreeObserver;
            this.f1428c = bVar;
        }

        public final void a(Throwable th) {
            this.f1426a.d(this.f1427b, this.f1428c);
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            a(th);
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"B1/j$b", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "()Z", Const.INTENT_KEY_APIKEY, "Z", "isResumed", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public boolean isResumed;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j<T> f1430b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f1431c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1066l<Size> f1432d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(j<T> jVar, ViewTreeObserver viewTreeObserver, InterfaceC1066l<? super Size> interfaceC1066l) {
            this.f1430b = jVar;
            this.f1431c = viewTreeObserver;
            this.f1432d = interfaceC1066l;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            Size size = this.f1430b.getSize();
            if (size != null) {
                this.f1430b.d(this.f1431c, this);
                if (!this.isResumed) {
                    this.isResumed = true;
                    this.f1432d.resumeWith(Result.b(size));
                }
            }
            return true;
        }
    }

    static /* synthetic */ <T extends View> Object b(j<T> jVar, InterfaceC4014c<? super Size> interfaceC4014c) {
        Size size = jVar.getSize();
        if (size != null) {
            return size;
        }
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        ViewTreeObserver viewTreeObserver = jVar.getView().getViewTreeObserver();
        b bVar = new b(jVar, viewTreeObserver, cVar);
        viewTreeObserver.addOnPreDrawListener(bVar);
        cVar.q(new a(jVar, viewTreeObserver, bVar));
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }

    @Override // B1.h
    default Object a(InterfaceC4014c<? super Size> interfaceC4014c) {
        return b(this, interfaceC4014c);
    }

    default c c(int paramSize, int viewSize, int paddingSize) {
        if (paramSize == -2) {
            return c.b.f1417a;
        }
        int i10 = paramSize - paddingSize;
        if (i10 > 0) {
            return B1.a.a(i10);
        }
        int i11 = viewSize - paddingSize;
        if (i11 > 0) {
            return B1.a.a(i11);
        }
        return null;
    }

    default void d(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        } else {
            getView().getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
        }
    }

    default boolean e() {
        return true;
    }

    default c getHeight() {
        ViewGroup.LayoutParams layoutParams = getView().getLayoutParams();
        return c(layoutParams != null ? layoutParams.height : -1, getView().getHeight(), e() ? getView().getPaddingTop() + getView().getPaddingBottom() : 0);
    }

    default Size getSize() {
        c height;
        c width = getWidth();
        if (width == null || (height = getHeight()) == null) {
            return null;
        }
        return new Size(width, height);
    }

    T getView();

    default c getWidth() {
        ViewGroup.LayoutParams layoutParams = getView().getLayoutParams();
        return c(layoutParams != null ? layoutParams.width : -1, getView().getWidth(), e() ? getView().getPaddingLeft() + getView().getPaddingRight() : 0);
    }
}
