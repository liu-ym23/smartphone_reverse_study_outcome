package com.stepos.ailauncher.express.net;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR$\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/express/net/b;", "", "", "amooExpressId", "", "Lcom/stepos/ailauncher/express/net/b$a;", "edited", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAmooExpressId", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.express.net.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AmooExpressData {

    @SerializedName("amoo_express_id")
    private final String amooExpressId;

    @SerializedName("edited")
    private final List<Edited> edited;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/express/net/b$a;", "", "", HomeGestureEligibilityContract.EXTRA_SCENE, "", "text", "imgData", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "getImgData", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.express.net.b$a, reason: from toString */
    public static final /* data */ class Edited {

        @SerializedName("img_data")
        private final List<String> imgData;

        @SerializedName(HomeGestureEligibilityContract.EXTRA_SCENE)
        private final String scene;

        @SerializedName("text")
        private final List<String> text;

        public Edited() {
            this(null, null, null, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final String getScene() {
            return this.scene;
        }

        public final List<String> b() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Edited)) {
                return false;
            }
            Edited edited = (Edited) other;
            return p.d(this.scene, edited.scene) && p.d(this.text, edited.text) && p.d(this.imgData, edited.imgData);
        }

        public int hashCode() {
            String str = this.scene;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.text.hashCode()) * 31) + this.imgData.hashCode();
        }

        public String toString() {
            return "Edited(scene=" + this.scene + ", text=" + this.text + ", imgData=" + this.imgData + ")";
        }

        public Edited(String str, List<String> text, List<String> imgData) {
            p.i(text, "text");
            p.i(imgData, "imgData");
            this.scene = str;
            this.text = text;
            this.imgData = imgData;
        }

        public /* synthetic */ Edited(String str, List list, List list2, int i10, i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? C1173v.m() : list, (i10 & 4) != 0 ? C1173v.m() : list2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AmooExpressData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<Edited> a() {
        return this.edited;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AmooExpressData)) {
            return false;
        }
        AmooExpressData amooExpressData = (AmooExpressData) other;
        return p.d(this.amooExpressId, amooExpressData.amooExpressId) && p.d(this.edited, amooExpressData.edited);
    }

    public int hashCode() {
        String str = this.amooExpressId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<Edited> list = this.edited;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "AmooExpressData(amooExpressId=" + this.amooExpressId + ", edited=" + this.edited + ")";
    }

    public AmooExpressData(String str, List<Edited> list) {
        this.amooExpressId = str;
        this.edited = list;
    }

    public /* synthetic */ AmooExpressData(String str, List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : list);
    }
}
