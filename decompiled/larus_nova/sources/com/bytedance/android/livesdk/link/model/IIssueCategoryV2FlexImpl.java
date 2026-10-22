package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.IssueCategoryV2")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IIssueCategoryV2FlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/o4;", "", "issueContent$delegate", "Ljava/lang/Object;", "getIssueContent", "()Ljava/lang/String;", "issueContent", "", "reportSerialId$delegate", "getReportSerialId", "()J", "reportSerialId", "", "subCategoryInputType$delegate", "getSubCategoryInputType", "()I", "subCategoryInputType", "", "subCategories$delegate", "getSubCategories", "()Ljava/util/List;", "subCategories", "feedBackType$delegate", "getFeedBackType", "feedBackType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IIssueCategoryV2FlexImpl extends FlexModelBase<o4> implements o4, vh7.h {

    @SerializedName("feedback_type")
    protected int _$$feedBackType;

    @SerializedName("content")
    protected String _$$issueContent;

    @SerializedName("report_serial_id")
    protected long _$$reportSerialId;

    @SerializedName("sub_categories")
    protected List<IIssueCategoryV2FlexImpl> _$$subCategories;

    @SerializedName("input_type")
    protected int _$$subCategoryInputType;

    public IIssueCategoryV2FlexImpl() {
        super(o4.class);
        this._$$issueContent = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.o4
    public final int getFeedBackType() {
        return this._$$feedBackType;
    }

    @Override // com.bytedance.android.livesdk.link.model.o4
    public final String getIssueContent() {
        return this._$$issueContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.o4
    public final long getReportSerialId() {
        return this._$$reportSerialId;
    }

    @Override // com.bytedance.android.livesdk.link.model.o4
    public final List<IIssueCategoryV2FlexImpl> getSubCategories() {
        return this._$$subCategories;
    }

    @Override // com.bytedance.android.livesdk.link.model.o4
    public final int getSubCategoryInputType() {
        return this._$$subCategoryInputType;
    }

    public IIssueCategoryV2FlexImpl(am3.g r100) {
        super(o4.class);
        this._$$subCategories = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$issueContent = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$reportSerialId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$subCategoryInputType = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$subCategories.add(new IIssueCategoryV2FlexImpl(r100));
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._$$feedBackType = r100.i();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$issueContent != null) goto L43;
        this._$$issueContent = "";
        return;
    }
}
