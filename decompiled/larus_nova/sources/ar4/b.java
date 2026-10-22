package ar4;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.c;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import com.bytedance.ee.bear.bitable.celleditor.editor.link.LinkEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.link.LinkTableEditorPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends c<LinkEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f16011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f16012e;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<LinkEditorModel> c() {
        return LinkEditorModel.class;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b e() {
        return this.f16012e;
    }

    public b(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f16011d = r100;
        this.f16012e = new a();
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final g d(CommonEditorModel r100) {
        Intrinsics.checkNotNullParameter((LinkEditorModel) r100, "data");
        hr4.a r101 = this.f16011d;
        a r102 = this.f16012e;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.celleditor.editor.link.LinkEditorActionHandler");
        return new LinkTableEditorPanel(r101, r102);
    }
}
