package com.android.ttcjpaysdk.bdpay.counter.outer.independent;

import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/OHomePageMethodFoldBean;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/OHomePageMethodBean;", "type", "", SocialConstants.PARAM_APP_DESC, "foldScene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "foldItemList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFoldItemList", "()Ljava/util/ArrayList;", "setFoldItemList", "(Ljava/util/ArrayList;)V", "getFoldScene", "status", "", "getStatus", "()I", "setStatus", "(I)V", "getType", "Companion", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OHomePageMethodFoldBean extends OHomePageMethodBean {
    public static final Companion Companion = null;
    public static final String FOLD_SCENE_GROUP = "group";
    public static final String FOLD_SCENE_GROUP_INNER = "group_inner";
    private final String desc;
    private ArrayList<Object> foldItemList;
    private final String foldScene;
    private int status;
    private final String type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/OHomePageMethodFoldBean$Companion;", "", "()V", "FOLD_SCENE_GROUP", "", "FOLD_SCENE_GROUP_INNER", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final String getDesc() {
        return this.desc;
    }

    public final ArrayList<Object> getFoldItemList() {
        return this.foldItemList;
    }

    public final String getFoldScene() {
        return this.foldScene;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }

    public final void setFoldItemList(ArrayList<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.foldItemList = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public OHomePageMethodFoldBean(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r102, "foldScene");
        this.type = r100;
        this.desc = r101;
        this.foldScene = r102;
        this.foldItemList = new ArrayList();
    }

    public /* synthetic */ OHomePageMethodFoldBean(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = FOLD_SCENE_GROUP_INNER;
    L5:
        this(r100, r101, r102);
    }
}
