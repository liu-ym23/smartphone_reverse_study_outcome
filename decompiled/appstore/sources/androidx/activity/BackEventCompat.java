package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class BackEventCompat {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f103e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f107d;

    @Target({ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/activity/BackEventCompat$SwipeEdge;", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface SwipeEdge {
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f103e = new a(null);
    }

    public BackEventCompat(float r10, float r11, float r12, int r13) {
        this.f104a = r10;
        this.f105b = r11;
        this.f106c = r12;
        this.f107d = r13;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f104a + ", touchY=" + this.f105b + ", progress=" + this.f106c + ", swipeEdge=" + this.f107d + '}';
    }

    @RequiresApi(34)
    public BackEventCompat(@NotNull BackEvent r10) {
        kotlin.jvm.internal.q.g(r10, "backEvent");
        b r11 = b.f164a;
        this(r11.d(r10), r11.e(r10), r11.b(r10), r11.c(r10));
    }
}
