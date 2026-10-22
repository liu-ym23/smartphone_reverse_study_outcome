package a5;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f121f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i8, int i9) {
        super(i8);
        this.f121f = i9;
    }

    @Override // a5.d
    public Object a(Object obj) {
        switch (this.f121f) {
            case 1:
                l4.c cVar = (l4.c) obj;
                ArrayList arrayList = cVar.f3803a;
                int size = arrayList.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj2 = arrayList.get(i8);
                    i8++;
                    l4.e.f3807a.y((int[]) obj2);
                }
                arrayList.clear();
                return cVar;
            case 2:
                int[] iArr = (int[]) obj;
                Arrays.fill(iArr, 0, iArr.length, -1);
                return iArr;
            default:
                return obj;
        }
    }

    @Override // a5.d
    public final Object b() {
        switch (this.f121f) {
            case 0:
                return new byte[4096];
            case 1:
                l4.c cVar = new l4.c();
                cVar.f3803a = new ArrayList();
                return cVar;
            case 2:
                int[] iArr = new int[768];
                for (int i8 = 0; i8 < 768; i8++) {
                    iArr[i8] = -1;
                }
                return iArr;
            default:
                return new char[2048];
        }
    }
}
