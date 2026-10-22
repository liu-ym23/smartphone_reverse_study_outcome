package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
import com.bytedance.ai.utils.g;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import h5.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u00102\u001a\u00020\bJ\u0018\u00103\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000206H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001c\u0010\"\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001c\u0010%\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001c\u0010(\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR \u0010+\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR\u0013\u0010.\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00069"}, d2 = {"Lcom/bytedance/ai/model/objects/Page;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "id", "getId", "setId", "input", "", "getInput", "()Ljava/lang/Object;", "setInput", "(Ljava/lang/Object;)V", "name", "getName", "setName", BdpAppEventConstant.PARAMS_OUTPUT, "getOutput", "setOutput", "entry", "getEntry", "setEntry", "title", "getTitle", d.f25925o, "digest", "getDigest", "setDigest", "renderType", "getRenderType", "setRenderType", "path", "getPath", "setPath", "chat", "getChat", "setChat", "chatConfig", "Lcom/bytedance/ai/model/objects/PageChatConfig;", "getChatConfig", "()Lcom/bytedance/ai/model/objects/PageChatConfig;", "pageId", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Page implements Parcelable {
    public static final a CREATOR = null;

    @JsonAdapter(ChatConfigStringAdapter.class)
    private String chat;
    private String description;
    private String digest;
    private String entry;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f36927id;
    private Object input;
    private String name;
    private Object output;
    private String path;
    private String renderType;
    private String title;

    public static final class a implements Parcelable.Creator<Page> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Page createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new Page(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Page[] newArray(int r100) {
            return new Page[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final PageChatConfig getChatConfig() {
        f r100 = f.f483817a;
        String r101 = this.chat;
        r100.getClass();
        return (PageChatConfig) f.a(r101, PageChatConfig.class);
    }

    public final String pageId() {
        if (com.bytedance.ai.utils.f.g(this.f36927id) == false) goto L7;
        String r100 = this.f36927id;
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        return this.name;
    }

    public Page() {
        this.description = "";
        this.f36927id = "";
        this.name = "";
        this.entry = "";
        this.title = "";
    }

    public final String getChat() {
        return this.chat;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDigest() {
        return this.digest;
    }

    public final String getEntry() {
        return this.entry;
    }

    public final String getId() {
        return this.f36927id;
    }

    public final Object getInput() {
        return this.input;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getOutput() {
        return this.output;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getRenderType() {
        return this.renderType;
    }

    public final String getTitle() {
        return this.title;
    }

    public Page(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        String r101 = r100.readString();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.description = r101;
        String r103 = r100.readString();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.f36927id = r103;
        String r104 = r100.readString();
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        this.name = r104;
        String r105 = r100.readString();
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        this.entry = r105;
        String r106 = r100.readString();
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        this.title = r106;
        this.digest = r100.readString();
        this.renderType = r100.readString();
        String r107 = null;
        this.input = null;
        this.output = null;
        String r108 = r100.readString();     // Catch: Exception -> L22
        if (r108 == null) goto L24;
        r102 = r108;
    L24:
        this.path = r102;
        r107 = r100.readString();     // Catch: Exception -> L28
    L26:
        this.chat = r107;
        return;
    L22:
        e = move-exception;
        g.f37637a.d("AIPackage", "read path from parcel exception: " + e);
        goto L24
    }

    public final void setChat(String r100) {
        this.chat = r100;
    }

    public final void setDescription(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.description = r100;
    }

    public final void setDigest(String r100) {
        this.digest = r100;
    }

    public final void setEntry(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entry = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f36927id = r100;
    }

    public final void setInput(Object r100) {
        this.input = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setOutput(Object r100) {
        this.output = r100;
    }

    public final void setPath(String r100) {
        this.path = r100;
    }

    public final void setRenderType(String r100) {
        this.renderType = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.description);
        r100.writeString(this.f36927id);
        r100.writeString(this.name);
        r100.writeString(this.entry);
        r100.writeString(this.title);
        r100.writeString(this.digest);
        r100.writeString(this.renderType);
        r100.writeString(this.path);
        r100.writeString(this.chat);
    }
}
