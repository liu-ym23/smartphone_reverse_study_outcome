package androidx.recyclerview.widget;

import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R \u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/recyclerview/widget/IUpDownRelationV2;", "", "dataAtBottom", "Ljava/lang/ref/WeakReference;", "getDataAtBottom", "()Ljava/lang/ref/WeakReference;", "setDataAtBottom", "(Ljava/lang/ref/WeakReference;)V", "dataAtTop", "getDataAtTop", "setDataAtTop", "bindDownData", "", "downData", "bindUpData", "upData", "getFixedRelationData", "hasFixedRelationData", "", "locallife-saas-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IUpDownRelationV2 {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    public static final class DefaultImpls {
        public static IUpDownRelationV2 getFixedRelationData(IUpDownRelationV2 r100) {
            WeakReference<IUpDownRelationV2> r101 = r100.getDataAtTop();
            if (r101 == null) goto L5;
            IUpDownRelationV2 r102 = r101.get();
        L6:
            if (r100 != r102) goto L11;
            WeakReference<IUpDownRelationV2> r103 = r100.getDataAtBottom();
            if (r103 != null) goto L10;
            return null;
        L10:
            return r103.get();
        L11:
            WeakReference<IUpDownRelationV2> r104 = r100.getDataAtBottom();
            if (r104 == null) goto L14;
            IUpDownRelationV2 r105 = r104.get();
        L15:
            if (r100 != r105) goto L21;
            WeakReference<IUpDownRelationV2> r106 = r100.getDataAtTop();
            if (r106 != null) goto L19;
            return null;
        L19:
            return r106.get();
        L21:
            return null;
        L14:
            r105 = null;
            goto L15
        L5:
            r102 = null;
            goto L6
        }

        public static boolean hasFixedRelationData(IUpDownRelationV2 r100) {
            if (r100.getFixedRelationData() == null) goto L5;
            return true;
        L5:
            return false;
        }

        public static void bindDownData(IUpDownRelationV2 r100, IUpDownRelationV2 r101) {
            r100.setDataAtTop(new WeakReference(r100));
            r100.setDataAtBottom(new WeakReference(r101));
        }

        public static void bindUpData(IUpDownRelationV2 r100, IUpDownRelationV2 r101) {
            r100.setDataAtTop(new WeakReference(r101));
            r100.setDataAtBottom(new WeakReference(r100));
        }
    }

    void bindDownData(IUpDownRelationV2 r100);

    void bindUpData(IUpDownRelationV2 r100);

    WeakReference<IUpDownRelationV2> getDataAtBottom();

    WeakReference<IUpDownRelationV2> getDataAtTop();

    IUpDownRelationV2 getFixedRelationData();

    boolean hasFixedRelationData();

    void setDataAtBottom(WeakReference<IUpDownRelationV2> r100);

    void setDataAtTop(WeakReference<IUpDownRelationV2> r100);
}
