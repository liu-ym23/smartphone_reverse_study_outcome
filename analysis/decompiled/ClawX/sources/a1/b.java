package a1;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i8, Class cls, String str) {
        super(cls, str);
        this.f1a = i8;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f1a) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return Float.valueOf(((View) obj).getTransitionAlpha());
            default:
                return ((View) obj).getClipBounds();
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f1a) {
            case 0:
                e eVar = (e) obj;
                PointF pointF = (PointF) obj2;
                eVar.getClass();
                eVar.f18a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                eVar.f19b = iRound;
                int i8 = eVar.f22f + 1;
                eVar.f22f = i8;
                if (i8 == eVar.f23g) {
                    View view = eVar.f21e;
                    int i9 = eVar.f18a;
                    int i10 = eVar.f20c;
                    int i11 = eVar.d;
                    b bVar = y.f78a;
                    view.setLeftTopRightBottom(i9, iRound, i10, i11);
                    eVar.f22f = 0;
                    eVar.f23g = 0;
                    break;
                }
                break;
            case 1:
                e eVar2 = (e) obj;
                PointF pointF2 = (PointF) obj2;
                eVar2.getClass();
                eVar2.f20c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                eVar2.d = iRound2;
                int i12 = eVar2.f23g + 1;
                eVar2.f23g = i12;
                if (eVar2.f22f == i12) {
                    View view2 = eVar2.f21e;
                    int i13 = eVar2.f18a;
                    int i14 = eVar2.f19b;
                    int i15 = eVar2.f20c;
                    b bVar2 = y.f78a;
                    view2.setLeftTopRightBottom(i13, i14, i15, iRound2);
                    eVar2.f22f = 0;
                    eVar2.f23g = 0;
                    break;
                }
                break;
            case 2:
                View view3 = (View) obj;
                PointF pointF3 = (PointF) obj2;
                int left = view3.getLeft();
                int top = view3.getTop();
                int iRound3 = Math.round(pointF3.x);
                int iRound4 = Math.round(pointF3.y);
                b bVar3 = y.f78a;
                view3.setLeftTopRightBottom(left, top, iRound3, iRound4);
                break;
            case 3:
                View view4 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                int iRound5 = Math.round(pointF4.x);
                int iRound6 = Math.round(pointF4.y);
                int right = view4.getRight();
                int bottom = view4.getBottom();
                b bVar4 = y.f78a;
                view4.setLeftTopRightBottom(iRound5, iRound6, right, bottom);
                break;
            case 4:
                View view5 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound7 = Math.round(pointF5.x);
                int iRound8 = Math.round(pointF5.y);
                int width = view5.getWidth() + iRound7;
                int height = view5.getHeight() + iRound8;
                b bVar5 = y.f78a;
                view5.setLeftTopRightBottom(iRound7, iRound8, width, height);
                break;
            case 5:
                ((View) obj).setTransitionAlpha(((Float) obj2).floatValue());
                break;
            default:
                ((View) obj).setClipBounds((Rect) obj2);
                break;
        }
    }
}
