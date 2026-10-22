package androidx.compose.ui.layout;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/layout/InnermostInsetsRulers;", "Landroidx/compose/ui/layout/WindowInsetsRulers;", "name", "", "rulers", "", "<init>", "(Ljava/lang/String;[Landroidx/compose/ui/layout/WindowInsetsRulers;)V", "getName", "()Ljava/lang/String;", "getRulers", "()[Landroidx/compose/ui/layout/WindowInsetsRulers;", "[Landroidx/compose/ui/layout/WindowInsetsRulers;", "current", "Landroidx/compose/ui/layout/RectRulers;", "getCurrent", "()Landroidx/compose/ui/layout/RectRulers;", "maximum", "getMaximum", "getAnimation", "Landroidx/compose/ui/layout/WindowInsetsAnimation;", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "toString", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class InnermostInsetsRulers implements WindowInsetsRulers {
    private final RectRulers current;
    private final RectRulers maximum;
    private final String name;
    private final WindowInsetsRulers[] rulers;

    public String toString() {
        String r100 = this.name;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ArraysKt.joinToString$default(this.rulers, null, "innermostOf(", ")", 0, null, null, 57, null);
    }

    @Override // androidx.compose.ui.layout.WindowInsetsRulers
    public RectRulers getCurrent() {
        return this.current;
    }

    @Override // androidx.compose.ui.layout.WindowInsetsRulers
    public RectRulers getMaximum() {
        return this.maximum;
    }

    public final String getName() {
        return this.name;
    }

    public final WindowInsetsRulers[] getRulers() {
        return this.rulers;
    }

    @Override // androidx.compose.ui.layout.WindowInsetsRulers
    public WindowInsetsAnimation getAnimation(Placeable.PlacementScope r100) {
        return new InnermostAnimationProperties(r100, this.rulers);
    }

    public InnermostInsetsRulers(String r100, WindowInsetsRulers[] r101) {
        this.name = r100;
        this.rulers = r101;
        RectRulers.Companion r102 = RectRulers.Companion;
        ArrayList r103 = new ArrayList(r101.length);
        int r104 = r101.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103.add(r101[r105].getCurrent());
        r105 = r105 + 1;
        goto L3
    L5:
        RectRulers[] r106 = (RectRulers[]) r103.toArray(new RectRulers[0]);
        this.current = RectRulersKt.innermostOf(r102, (RectRulers[]) Arrays.copyOf(r106, r106.length));
        RectRulers.Companion r107 = RectRulers.Companion;
        WindowInsetsRulers[] r108 = this.rulers;
        ArrayList r109 = new ArrayList(r108.length);
        int r110 = r108.length;
        int r111 = 0;
    L6:
        if (r111 >= r110) goto L8;
        r109.add(r108[r111].getMaximum());
        r111 = r111 + 1;
        goto L6
    L8:
        RectRulers[] r112 = (RectRulers[]) r109.toArray(new RectRulers[0]);
        this.maximum = RectRulersKt.innermostOf(r107, (RectRulers[]) Arrays.copyOf(r112, r112.length));
    }
}
