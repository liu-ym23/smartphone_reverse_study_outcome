package b;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import b.N;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\" \u0010\r\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\" \u0010\u0011\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u0012\u0004\b\u0010\u0010\f\u001a\u0004\b\u000f\u0010\n\"\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lb/q;", "Lb/N;", "statusBarStyle", "navigationBarStyle", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lb/q;Lb/N;Lb/N;)V", "", "I", "getDefaultLightScrim", "()I", "getDefaultLightScrim$annotations", "()V", "DefaultLightScrim", Const.INTENT_KEY_PKGNAME, "getDefaultDarkScrim", "getDefaultDarkScrim$annotations", "DefaultDarkScrim", "Lb/C;", "c", "Lb/C;", "Impl", "activity_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final int f15222a = Color.argb(230, 255, 255, 255);

    /* renamed from: b, reason: collision with root package name */
    public static final int f15223b = Color.argb(128, 27, 27, 27);

    /* renamed from: c, reason: collision with root package name */
    public static InterfaceC1413C f15224c;

    public static final void a(q qVar, N statusBarStyle, N navigationBarStyle) {
        kotlin.jvm.internal.p.i(qVar, "<this>");
        kotlin.jvm.internal.p.i(statusBarStyle, "statusBarStyle");
        kotlin.jvm.internal.p.i(navigationBarStyle, "navigationBarStyle");
        View decorView = qVar.getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        InterfaceC5074l<Resources, Boolean> interfaceC5074lA = statusBarStyle.a();
        Resources resources = decorView.getResources();
        kotlin.jvm.internal.p.h(resources, "getResources(...)");
        boolean zBooleanValue = interfaceC5074lA.invoke(resources).booleanValue();
        InterfaceC5074l<Resources, Boolean> interfaceC5074lA2 = navigationBarStyle.a();
        Resources resources2 = decorView.getResources();
        kotlin.jvm.internal.p.h(resources2, "getResources(...)");
        boolean zBooleanValue2 = interfaceC5074lA2.invoke(resources2).booleanValue();
        InterfaceC1413C c1411a = f15224c;
        if (c1411a == null) {
            c1411a = new C1411A();
        }
        InterfaceC1413C interfaceC1413C = c1411a;
        Window window = qVar.getWindow();
        kotlin.jvm.internal.p.h(window, "getWindow(...)");
        interfaceC1413C.a(statusBarStyle, navigationBarStyle, window, decorView, zBooleanValue, zBooleanValue2);
        Window window2 = qVar.getWindow();
        kotlin.jvm.internal.p.h(window2, "getWindow(...)");
        interfaceC1413C.b(window2);
    }

    public static /* synthetic */ void b(q qVar, N n10, N n11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            n10 = N.Companion.c(N.INSTANCE, 0, 0, null, 4, null);
        }
        if ((i10 & 2) != 0) {
            n11 = N.Companion.c(N.INSTANCE, f15222a, f15223b, null, 4, null);
        }
        a(qVar, n10, n11);
    }
}
