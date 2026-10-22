package com.stepos.ailauncher.express.net;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001a\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/express/net/e;", "", "", "amooExpressId", "editScene", "", "Lcom/stepos/ailauncher/express/net/e$a;", "edits", "bizScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAmooExpressId", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "getBizScene", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.express.net.e, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AmooExpressRequest {

    @SerializedName("amoo_express_id")
    private final String amooExpressId;

    @SerializedName("biz_scene")
    private final String bizScene;

    @SerializedName("edit_scene")
    private final String editScene;

    @SerializedName("edits")
    private final List<Edit> edits;

    public AmooExpressRequest(String amooExpressId, String editScene, List<Edit> edits, String bizScene) {
        p.i(amooExpressId, "amooExpressId");
        p.i(editScene, "editScene");
        p.i(edits, "edits");
        p.i(bizScene, "bizScene");
        this.amooExpressId = amooExpressId;
        this.editScene = editScene;
        this.edits = edits;
        this.bizScene = bizScene;
    }

    /* renamed from: a, reason: from getter */
    public final String getEditScene() {
        return this.editScene;
    }

    public final List<Edit> b() {
        return this.edits;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AmooExpressRequest)) {
            return false;
        }
        AmooExpressRequest amooExpressRequest = (AmooExpressRequest) other;
        return p.d(this.amooExpressId, amooExpressRequest.amooExpressId) && p.d(this.editScene, amooExpressRequest.editScene) && p.d(this.edits, amooExpressRequest.edits) && p.d(this.bizScene, amooExpressRequest.bizScene);
    }

    public int hashCode() {
        return (((((this.amooExpressId.hashCode() * 31) + this.editScene.hashCode()) * 31) + this.edits.hashCode()) * 31) + this.bizScene.hashCode();
    }

    public String toString() {
        return "AmooExpressRequest(amooExpressId=" + this.amooExpressId + ", editScene=" + this.editScene + ", edits=" + this.edits + ", bizScene=" + this.bizScene + ")";
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/express/net/e$a;", "", "", HomeGestureEligibilityContract.EXTRA_SCENE, "", "text", "imgData", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "getText", "()Ljava/util/List;", "getImgData", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.express.net.e$a, reason: from toString */
    public static final /* data */ class Edit {

        @SerializedName("img_data")
        private final List<String> imgData;

        @SerializedName(HomeGestureEligibilityContract.EXTRA_SCENE)
        private final String scene;

        @SerializedName("text")
        private final List<String> text;

        public Edit(String scene, List<String> text, List<String> imgData) {
            p.i(scene, "scene");
            p.i(text, "text");
            p.i(imgData, "imgData");
            this.scene = scene;
            this.text = text;
            this.imgData = imgData;
        }

        /* renamed from: a, reason: from getter */
        public final String getScene() {
            return this.scene;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Edit)) {
                return false;
            }
            Edit edit = (Edit) other;
            return p.d(this.scene, edit.scene) && p.d(this.text, edit.text) && p.d(this.imgData, edit.imgData);
        }

        public int hashCode() {
            return (((this.scene.hashCode() * 31) + this.text.hashCode()) * 31) + this.imgData.hashCode();
        }

        public String toString() {
            return "Edit(scene=" + this.scene + ", text=" + this.text + ", imgData=" + this.imgData + ")";
        }

        public /* synthetic */ Edit(String str, List list, List list2, int i10, i iVar) {
            this(str, list, (i10 & 4) != 0 ? C1173v.m() : list2);
        }
    }
}
