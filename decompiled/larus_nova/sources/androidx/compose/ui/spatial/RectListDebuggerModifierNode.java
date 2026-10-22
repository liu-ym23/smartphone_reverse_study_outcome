package androidx.compose.ui.spatial;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\f\u0010\u0011\u001a\u00020\u000f*\u00020\u0012H\u0016R\u0012\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/spatial/RectListDebuggerModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "paint", "Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/NativePaint;", "token", "", "getToken", "()Ljava/lang/Object;", "setToken", "(Ljava/lang/Object;)V", "onAttach", "", "onDetach", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RectListDebuggerModifierNode extends Modifier.Node implements DrawModifierNode {
    private Paint paint;
    private Object token;

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    public RectListDebuggerModifierNode() {
        androidx.compose.ui.graphics.Paint r100 = AndroidPaint_androidKt.Paint();
        r100.mo4704setColor8_81llA(Color.Companion.m4861getRed0d7_KjU());
        r100.mo4708setStylek9PVt8s(PaintingStyle.Companion.m5115getStrokeTiuSbCo());
        this.paint = r100.asFrameworkPaint();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.token = DelegatableNodeKt.requireOwner(this).getRectManager().registerOnChangedCallback(new AnonymousClass1(this));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DelegatableNodeKt.requireOwner(this).getRectManager().unregisterOnChangedCallback(this.token);
    }

    public final Object getToken() {
        return this.token;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope r110) {
        RectList r100 = DelegatableNodeKt.requireOwner(this).getRectManager().getRects();
        Canvas r111 = AndroidCanvas_androidKt.getNativeCanvas(r110.getDrawContext().getCanvas());
        Paint r101 = this.paint;
        long[] r102 = r100.items;
        int r103 = r100.itemsSize;
        int r104 = 0;
    L4:
        if (r104 >= (r102.length - 2)) goto L7;
        if (r104 >= r103) goto L10;
        long r105 = r102[r104 + 0];
        long r106 = r102[r104 + 1];
        long r107 = r102[r104 + 2];
        r111.drawRect((int) (r105 >> 32), (int) r105, (int) (r106 >> 32), (int) r106, r101);
        r104 = r104 + 3;
        goto L4
    L10:
        return;
    }

    public final void setToken(Object r100) {
        this.token = r100;
    }
}
