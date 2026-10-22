package b;

import android.view.Window;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lb/y;", "Lb/x;", "<init>", "()V", "Landroid/view/Window;", "window", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/Window;)V", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class y extends x {
    @Override // b.C1412B, b.InterfaceC1413C
    public void b(Window window) {
        kotlin.jvm.internal.p.i(window, "window");
        window.getAttributes().layoutInDisplayCutoutMode = 1;
    }
}
