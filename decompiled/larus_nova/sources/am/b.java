package am;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lam/b;", "", "", "", "bizTags", "Ljava/util/List;", "getBizTags", "()Ljava/util/List;", "sceneTags", "getSceneTags", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "", "type", "I", "getType", "()I", "<init>", "()V", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("biz_tags")
    private final List<String> bizTags;

    @SerializedName("content")
    private final String content;

    @SerializedName("scene_tags")
    private final List<String> sceneTags;

    @SerializedName("type")
    private final int type;

    public b() {
        this.type = 1;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "url");
        List<String> r103 = this.bizTags;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L14;
        if (r100 != null) goto L12;
    L13:
        return false;
    L12:
        if (this.bizTags.contains(r100) == false) goto L13;
    L14:
        List<String> r105 = this.sceneTags;
        if (r105 != null) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == true) goto L26;
        if (r101 != null) goto L24;
    L25:
        return false;
    L24:
        if (this.sceneTags.contains(r101) == false) goto L25;
    L26:
        String r107 = this.content;
        if (r107 != null) goto L29;
    L31:
        return true;
    L29:
        if (StringsKt.contains$default(r102, r107, false, 2, null) == true) goto L31;
        return false;
    L17:
        if (r105.isEmpty() == true) goto L20;
        r106 = false;
        goto L21
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }
}
