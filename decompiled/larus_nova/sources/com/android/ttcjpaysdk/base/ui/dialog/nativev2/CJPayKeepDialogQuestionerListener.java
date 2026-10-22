package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayKeepDialogQuestionerListener;", "", "onQuestionerSelect", "", "questioner", "", "onQuestionerShow", "questionerList", "", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJPayKeepDialogQuestionerListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onQuestionerSelect(CJPayKeepDialogQuestionerListener r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "questioner");
        }

        public static void onQuestionerShow(CJPayKeepDialogQuestionerListener r100, List<UIComponent> r101) {
        }

        public static /* synthetic */ void onQuestionerSelect$default(CJPayKeepDialogQuestionerListener r100, String r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = "";
        L6:
            r100.onQuestionerSelect(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onQuestionerSelect");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onQuestionerShow$default(CJPayKeepDialogQuestionerListener r100, List r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = CollectionsKt.emptyList();
        L6:
            r100.onQuestionerShow(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onQuestionerShow");
        }
    }

    void onQuestionerSelect(String r100);

    void onQuestionerShow(List<UIComponent> r100);
}
