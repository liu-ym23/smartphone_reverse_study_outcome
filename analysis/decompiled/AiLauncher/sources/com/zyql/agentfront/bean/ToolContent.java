package com.zyql.agentfront.bean;

import Z8.C1173v;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u0010\u0010\u001e\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0012J\u001a\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b\u0006\u0010\u001a¨\u0006("}, d2 = {"Lcom/zyql/agentfront/bean/ToolContent;", "Landroid/os/Parcelable;", "", "Lcom/zyql/agentfront/bean/ToolContentItem;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "isError", "<init>", "(Ljava/util/List;Z)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "getText", "()Ljava/lang/String;", "getImageUrls", "()Ljava/util/List;", "component1", "component2", "()Z", ChatTracker.CLICK_COPY, "(Ljava/util/List;Z)Lcom/zyql/agentfront/bean/ToolContent;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getContent", "Z", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ToolContent implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_RESOURCE = "resource";
    public static final String TYPE_TEXT = "text";
    private final List<ToolContentItem> content;
    private final boolean isError;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/zyql/agentfront/bean/ToolContent$a;", "Landroid/os/Parcelable$Creator;", "Lcom/zyql/agentfront/bean/ToolContent;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/zyql/agentfront/bean/ToolContent;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/zyql/agentfront/bean/ToolContent;", "", "TYPE_TEXT", "Ljava/lang/String;", "TYPE_IMAGE", "TYPE_RESOURCE", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.zyql.agentfront.bean.ToolContent$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<ToolContent> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ToolContent createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new ToolContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ToolContent[] newArray(int size) {
            return new ToolContent[size];
        }

        public Companion() {
        }
    }

    public ToolContent(List<ToolContentItem> content, boolean z10) {
        p.i(content, "content");
        this.content = content;
        this.isError = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToolContent copy$default(ToolContent toolContent, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = toolContent.content;
        }
        if ((i10 & 2) != 0) {
            z10 = toolContent.isError;
        }
        return toolContent.copy(list, z10);
    }

    public final List<ToolContentItem> component1() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    public final ToolContent copy(List<ToolContentItem> content, boolean isError) {
        p.i(content, "content");
        return new ToolContent(content, isError);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolContent)) {
            return false;
        }
        ToolContent toolContent = (ToolContent) other;
        return p.d(this.content, toolContent.content) && this.isError == toolContent.isError;
    }

    public final List<ToolContentItem> getContent() {
        return this.content;
    }

    public final List<String> getImageUrls() {
        List<ToolContentItem> list = this.content;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (p.d(((ToolContentItem) obj).getType(), "image")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String imageUrl = ((ToolContentItem) it.next()).getImageUrl();
            if (imageUrl != null) {
                arrayList2.add(imageUrl);
            }
        }
        return arrayList2;
    }

    public final String getText() {
        Object next;
        Iterator<T> it = this.content.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (p.d(((ToolContentItem) next).getType(), "text")) {
                break;
            }
        }
        ToolContentItem toolContentItem = (ToolContentItem) next;
        if (toolContentItem != null) {
            return toolContentItem.getText();
        }
        return null;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + Boolean.hashCode(this.isError);
    }

    public final boolean isError() {
        return this.isError;
    }

    public String toString() {
        return "ToolContent(content=" + this.content + ", isError=" + this.isError + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeTypedList(this.content);
        parcel.writeByte(this.isError ? (byte) 1 : (byte) 0);
    }

    public /* synthetic */ ToolContent(List list, boolean z10, int i10, i iVar) {
        this(list, (i10 & 2) != 0 ? false : z10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ToolContent(Parcel parcel) {
        p.i(parcel, "parcel");
        List listCreateTypedArrayList = parcel.createTypedArrayList(ToolContentItem.INSTANCE);
        this(listCreateTypedArrayList == null ? C1173v.m() : listCreateTypedArrayList, parcel.readByte() != 0);
    }
}
