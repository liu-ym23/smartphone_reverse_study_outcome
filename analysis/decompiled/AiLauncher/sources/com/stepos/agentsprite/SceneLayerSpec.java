package com.stepos.agentsprite;

import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000e\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\f\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec;", "", "<init>", "()V", "f", Const.INTENT_KEY_APIKEY, "l", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_COMMAND, "k", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "c", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "TileMode", "Anchor", "Lcom/stepos/agentsprite/SceneLayerSpec$a;", "Lcom/stepos/agentsprite/SceneLayerSpec$b;", "Lcom/stepos/agentsprite/SceneLayerSpec$c;", "Lcom/stepos/agentsprite/SceneLayerSpec$d;", "Lcom/stepos/agentsprite/SceneLayerSpec$e;", "Lcom/stepos/agentsprite/SceneLayerSpec$f;", "Lcom/stepos/agentsprite/SceneLayerSpec$g;", "Lcom/stepos/agentsprite/SceneLayerSpec$h;", "Lcom/stepos/agentsprite/SceneLayerSpec$i;", "Lcom/stepos/agentsprite/SceneLayerSpec$j;", "Lcom/stepos/agentsprite/SceneLayerSpec$k;", "Lcom/stepos/agentsprite/SceneLayerSpec$l;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SceneLayerSpec {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$Anchor;", "", "<init>", "(Ljava/lang/String;I)V", "TopLeft", "TopCenter", "TopRight", "CenterStart", "Center", "CenterEnd", "BottomLeft", "BottomCenter", "BottomRight", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Anchor {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Anchor[] $VALUES;
        public static final Anchor TopLeft = new Anchor("TopLeft", 0);
        public static final Anchor TopCenter = new Anchor("TopCenter", 1);
        public static final Anchor TopRight = new Anchor("TopRight", 2);
        public static final Anchor CenterStart = new Anchor("CenterStart", 3);
        public static final Anchor Center = new Anchor("Center", 4);
        public static final Anchor CenterEnd = new Anchor("CenterEnd", 5);
        public static final Anchor BottomLeft = new Anchor("BottomLeft", 6);
        public static final Anchor BottomCenter = new Anchor("BottomCenter", 7);
        public static final Anchor BottomRight = new Anchor("BottomRight", 8);

        private static final /* synthetic */ Anchor[] $values() {
            return new Anchor[]{TopLeft, TopCenter, TopRight, CenterStart, Center, CenterEnd, BottomLeft, BottomCenter, BottomRight};
        }

        static {
            Anchor[] anchorArr$values = $values();
            $VALUES = anchorArr$values;
            $ENTRIES = a.a(anchorArr$values);
        }

        private Anchor(String str, int i10) {
        }

        public static InterfaceC4149a<Anchor> getEntries() {
            return $ENTRIES;
        }

        public static Anchor valueOf(String str) {
            return (Anchor) Enum.valueOf(Anchor.class, str);
        }

        public static Anchor[] values() {
            return (Anchor[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;", "", "<init>", "(Ljava/lang/String;I)V", "Repeat", "Single", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TileMode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ TileMode[] $VALUES;
        public static final TileMode Repeat = new TileMode("Repeat", 0);
        public static final TileMode Single = new TileMode("Single", 1);

        private static final /* synthetic */ TileMode[] $values() {
            return new TileMode[]{Repeat, Single};
        }

        static {
            TileMode[] tileModeArr$values = $values();
            $VALUES = tileModeArr$values;
            $ENTRIES = a.a(tileModeArr$values);
        }

        private TileMode(String str, int i10) {
        }

        public static InterfaceC4149a<TileMode> getEntries() {
            return $ENTRIES;
        }

        public static TileMode valueOf(String str) {
            return (TileMode) Enum.valueOf(TileMode.class, str);
        }

        public static TileMode[] values() {
            return (TileMode[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$a;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "resId", "<init>", "(I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$a, reason: from toString */
    public static final /* data */ class Drawable extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int resId;

        public Drawable(int i10) {
            super(null);
            this.resId = i10;
        }

        /* renamed from: a, reason: from getter */
        public final int getResId() {
            return this.resId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Drawable) && this.resId == ((Drawable) other).resId;
        }

        public int hashCode() {
            return Integer.hashCode(this.resId);
        }

        public String toString() {
            return "Drawable(resId=" + this.resId + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0017\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$b;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "", "resIds", "fps", "loop", "<init>", "(Ljava/util/List;II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "c", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "I", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$b, reason: from toString */
    public static final /* data */ class Frames extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<Integer> resIds;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int fps;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int loop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Frames(List<Integer> resIds, int i10, int i11) {
            super(null);
            p.i(resIds, "resIds");
            this.resIds = resIds;
            this.fps = i10;
            this.loop = i11;
        }

        /* renamed from: a, reason: from getter */
        public final int getFps() {
            return this.fps;
        }

        /* renamed from: b, reason: from getter */
        public final int getLoop() {
            return this.loop;
        }

        public final List<Integer> c() {
            return this.resIds;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Frames)) {
                return false;
            }
            Frames frames = (Frames) other;
            return p.d(this.resIds, frames.resIds) && this.fps == frames.fps && this.loop == frames.loop;
        }

        public int hashCode() {
            return (((this.resIds.hashCode() * 31) + Integer.hashCode(this.fps)) * 31) + Integer.hashCode(this.loop);
        }

        public String toString() {
            return "Frames(resIds=" + this.resIds + ", fps=" + this.fps + ", loop=" + this.loop + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$c;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "html", "", "sandbox", "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Z", "()Z", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$c, reason: from toString */
    public static final /* data */ class Html extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String html;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean sandbox;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Html(String html, boolean z10) {
            super(null);
            p.i(html, "html");
            this.html = html;
            this.sandbox = z10;
        }

        /* renamed from: a, reason: from getter */
        public final String getHtml() {
            return this.html;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getSandbox() {
            return this.sandbox;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Html)) {
                return false;
            }
            Html html = (Html) other;
            return p.d(this.html, html.html) && this.sandbox == html.sandbox;
        }

        public int hashCode() {
            return (this.html.hashCode() * 31) + Boolean.hashCode(this.sandbox);
        }

        public String toString() {
            return "Html(html=" + this.html + ", sandbox=" + this.sandbox + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$d;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "resId", "loop", "", Const.JSON_KEY_SPEED, "<init>", "(IIF)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, "c", "F", "()F", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$d, reason: from toString */
    public static final /* data */ class Lottie extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int resId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int loop;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final float speed;

        public Lottie(int i10, int i11, float f10) {
            super(null);
            this.resId = i10;
            this.loop = i11;
            this.speed = f10;
        }

        /* renamed from: a, reason: from getter */
        public final int getLoop() {
            return this.loop;
        }

        /* renamed from: b, reason: from getter */
        public final int getResId() {
            return this.resId;
        }

        /* renamed from: c, reason: from getter */
        public final float getSpeed() {
            return this.speed;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Lottie)) {
                return false;
            }
            Lottie lottie = (Lottie) other;
            return this.resId == lottie.resId && this.loop == lottie.loop && Float.compare(this.speed, lottie.speed) == 0;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.resId) * 31) + Integer.hashCode(this.loop)) * 31) + Float.hashCode(this.speed);
        }

        public String toString() {
            return "Lottie(resId=" + this.resId + ", loop=" + this.loop + ", speed=" + this.speed + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$e;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "md", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getMd", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$e, reason: from toString */
    public static final /* data */ class Markdown extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String md;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Markdown(String md) {
            super(null);
            p.i(md, "md");
            this.md = md;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Markdown) && p.d(this.md, ((Markdown) other).md);
        }

        public int hashCode() {
            return this.md.hashCode();
        }

        public String toString() {
            return "Markdown(md=" + this.md + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$f;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class f extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name */
        public static final f f23369a = new f();

        public f() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof f);
        }

        public int hashCode() {
            return 1657749969;
        }

        public String toString() {
            return "None";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u0016\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$g;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "asset", "", "loop", "", Const.JSON_KEY_SPEED, "fps", "<init>", "(Ljava/lang/String;IFLjava/lang/Float;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "I", "c", "F", Const.INTENT_KEY_UMID, "()F", "Ljava/lang/Float;", "()Ljava/lang/Float;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$g, reason: from toString */
    public static final /* data */ class Pag extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String asset;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int loop;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final float speed;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final Float fps;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pag(String asset, int i10, float f10, Float f11) {
            super(null);
            p.i(asset, "asset");
            this.asset = asset;
            this.loop = i10;
            this.speed = f10;
            this.fps = f11;
        }

        /* renamed from: a, reason: from getter */
        public final String getAsset() {
            return this.asset;
        }

        /* renamed from: b, reason: from getter */
        public final Float getFps() {
            return this.fps;
        }

        /* renamed from: c, reason: from getter */
        public final int getLoop() {
            return this.loop;
        }

        /* renamed from: d, reason: from getter */
        public final float getSpeed() {
            return this.speed;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pag)) {
                return false;
            }
            Pag pag = (Pag) other;
            return p.d(this.asset, pag.asset) && this.loop == pag.loop && Float.compare(this.speed, pag.speed) == 0 && p.d(this.fps, pag.fps);
        }

        public int hashCode() {
            int iHashCode = ((((this.asset.hashCode() * 31) + Integer.hashCode(this.loop)) * 31) + Float.hashCode(this.speed)) * 31;
            Float f10 = this.fps;
            return iHashCode + (f10 == null ? 0 : f10.hashCode());
        }

        public String toString() {
            return "Pag(asset=" + this.asset + ", loop=" + this.loop + ", speed=" + this.speed + ", fps=" + this.fps + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$h;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "resId", "<init>", "(I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getResId", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$h, reason: from toString */
    public static final /* data */ class Raw extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int resId;

        public Raw(int i10) {
            super(null);
            this.resId = i10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Raw) && this.resId == ((Raw) other).resId;
        }

        public int hashCode() {
            return Integer.hashCode(this.resId);
        }

        public String toString() {
            return "Raw(resId=" + this.resId + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$i;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "url", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getUrl", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$i, reason: from toString */
    public static final /* data */ class RemoteImage extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoteImage(String url) {
            super(null);
            p.i(url, "url");
            this.url = url;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RemoteImage) && p.d(this.url, ((RemoteImage) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "RemoteImage(url=" + this.url + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$j;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "svg", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getSvg", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$j, reason: from toString */
    public static final /* data */ class RemoteSvg extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String svg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoteSvg(String svg) {
            super(null);
            p.i(svg, "svg");
            this.svg = svg;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RemoteSvg) && p.d(this.svg, ((RemoteSvg) other).svg);
        }

        public int hashCode() {
            return this.svg.hashCode();
        }

        public String toString() {
            return "RemoteSvg(svg=" + this.svg + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$k;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "resId", "columns", "rows", "frameCount", "fps", "loop", "<init>", "(IIIIII)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "e", Const.INTENT_KEY_PKGNAME, "c", "f", Const.INTENT_KEY_UMID, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$k, reason: from toString */
    public static final /* data */ class SpriteSheet extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int resId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int columns;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int rows;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final int frameCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final int fps;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final int loop;

        public SpriteSheet(int i10, int i11, int i12, int i13, int i14, int i15) {
            super(null);
            this.resId = i10;
            this.columns = i11;
            this.rows = i12;
            this.frameCount = i13;
            this.fps = i14;
            this.loop = i15;
        }

        /* renamed from: a, reason: from getter */
        public final int getColumns() {
            return this.columns;
        }

        /* renamed from: b, reason: from getter */
        public final int getFps() {
            return this.fps;
        }

        /* renamed from: c, reason: from getter */
        public final int getFrameCount() {
            return this.frameCount;
        }

        /* renamed from: d, reason: from getter */
        public final int getLoop() {
            return this.loop;
        }

        /* renamed from: e, reason: from getter */
        public final int getResId() {
            return this.resId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpriteSheet)) {
                return false;
            }
            SpriteSheet spriteSheet = (SpriteSheet) other;
            return this.resId == spriteSheet.resId && this.columns == spriteSheet.columns && this.rows == spriteSheet.rows && this.frameCount == spriteSheet.frameCount && this.fps == spriteSheet.fps && this.loop == spriteSheet.loop;
        }

        /* renamed from: f, reason: from getter */
        public final int getRows() {
            return this.rows;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.resId) * 31) + Integer.hashCode(this.columns)) * 31) + Integer.hashCode(this.rows)) * 31) + Integer.hashCode(this.frameCount)) * 31) + Integer.hashCode(this.fps)) * 31) + Integer.hashCode(this.loop);
        }

        public String toString() {
            return "SpriteSheet(resId=" + this.resId + ", columns=" + this.columns + ", rows=" + this.rows + ", frameCount=" + this.frameCount + ", fps=" + this.fps + ", loop=" + this.loop + ")";
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b1\u0010)\u001a\u0004\b2\u0010+R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u00067"}, d2 = {"Lcom/stepos/agentsprite/SceneLayerSpec$l;", "Lcom/stepos/agentsprite/SceneLayerSpec;", "", "", "lines", "Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;", "tileMode", "", "colorArgb", "", "fontSizeSp", "", "fontResId", "lineHeightEm", "letterSpacingEm", "Lcom/stepos/agentsprite/SceneLayerSpec$Anchor;", LinkHeader.Parameters.Anchor, "<init>", "(Ljava/util/List;Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;JFIFFLcom/stepos/agentsprite/SceneLayerSpec$Anchor;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "getLines", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;", "getTileMode", "()Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;", "c", "J", "getColorArgb", "()J", Const.INTENT_KEY_UMID, "F", "getFontSizeSp", "()F", "e", "I", "getFontResId", "f", "getLineHeightEm", Const.INTENT_KEY_BACKGROUND_COMMAND, "getLetterSpacingEm", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/agentsprite/SceneLayerSpec$Anchor;", "getAnchor", "()Lcom/stepos/agentsprite/SceneLayerSpec$Anchor;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.stepos.agentsprite.SceneLayerSpec$l, reason: from toString */
    public static final /* data */ class Text extends SceneLayerSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<String> lines;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final TileMode tileMode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final long colorArgb;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final float fontSizeSp;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final int fontResId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final float lineHeightEm;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final float letterSpacingEm;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        public final Anchor anchor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(List<String> lines, TileMode tileMode, long j10, float f10, int i10, float f11, float f12, Anchor anchor) {
            super(null);
            p.i(lines, "lines");
            p.i(tileMode, "tileMode");
            p.i(anchor, "anchor");
            this.lines = lines;
            this.tileMode = tileMode;
            this.colorArgb = j10;
            this.fontSizeSp = f10;
            this.fontResId = i10;
            this.lineHeightEm = f11;
            this.letterSpacingEm = f12;
            this.anchor = anchor;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Text)) {
                return false;
            }
            Text text = (Text) other;
            return p.d(this.lines, text.lines) && this.tileMode == text.tileMode && this.colorArgb == text.colorArgb && Float.compare(this.fontSizeSp, text.fontSizeSp) == 0 && this.fontResId == text.fontResId && Float.compare(this.lineHeightEm, text.lineHeightEm) == 0 && Float.compare(this.letterSpacingEm, text.letterSpacingEm) == 0 && this.anchor == text.anchor;
        }

        public int hashCode() {
            return (((((((((((((this.lines.hashCode() * 31) + this.tileMode.hashCode()) * 31) + Long.hashCode(this.colorArgb)) * 31) + Float.hashCode(this.fontSizeSp)) * 31) + Integer.hashCode(this.fontResId)) * 31) + Float.hashCode(this.lineHeightEm)) * 31) + Float.hashCode(this.letterSpacingEm)) * 31) + this.anchor.hashCode();
        }

        public String toString() {
            return "Text(lines=" + this.lines + ", tileMode=" + this.tileMode + ", colorArgb=" + this.colorArgb + ", fontSizeSp=" + this.fontSizeSp + ", fontResId=" + this.fontResId + ", lineHeightEm=" + this.lineHeightEm + ", letterSpacingEm=" + this.letterSpacingEm + ", anchor=" + this.anchor + ")";
        }
    }

    public /* synthetic */ SceneLayerSpec(i iVar) {
        this();
    }

    public SceneLayerSpec() {
    }
}
