package M4;

import La.C0953c;
import La.D;
import La.H;
import Z8.C1173v;
import Z8.F;
import Z8.M;
import Z8.Q;
import android.content.res.Resources;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.agentsprite.SceneLayerSpec;
import io.ktor.http.ContentType;
import io.ktor.http.LinkHeader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import org.json.JSONArray;
import org.json.JSONObject;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0007\u0011\u0019\u001d\u001b\u000f\u0016\u000bB\u001d\b\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0010J)\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001f¨\u0006 "}, d2 = {"LM4/e;", "", "", "", "LM4/e$a;", "agents", "<init>", "(Ljava/util/Map;)V", "agentId", "skinKey", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "stateKey", "placeKey", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LM4/e$g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)LM4/e$g;", "emotionKey", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "LM4/e$c;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)LM4/e$c;", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)LM4/e$g;", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Map;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<String, a> agents;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\t\u0010\u000e¨\u0006\u000f"}, d2 = {"LM4/e$a;", "", "", "", "LM4/e$f;", "skins", "fallback", "<init>", "(Ljava/util/Map;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Map;", "Ljava/lang/String;", "()Ljava/lang/String;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Map<String, f> skins;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String fallback;

        public a(Map<String, f> skins, String fallback) {
            kotlin.jvm.internal.p.i(skins, "skins");
            kotlin.jvm.internal.p.i(fallback, "fallback");
            this.skins = skins;
            this.fallback = fallback;
        }

        /* renamed from: a, reason: from getter */
        public final String getFallback() {
            return this.fallback;
        }

        public final Map<String, f> b() {
            return this.skins;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0010\u0010\b¨\u0006\u0013"}, d2 = {"LM4/e$b;", "", "", "name", Const.JSON_KEY_DESC, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: M4.e$b, reason: from toString */
    public static final /* data */ class AnimationMeta {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String desc;

        public AnimationMeta(String name, String desc) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(desc, "desc");
            this.name = name;
            this.desc = desc;
        }

        /* renamed from: a, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        /* renamed from: b, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimationMeta)) {
                return false;
            }
            AnimationMeta animationMeta = (AnimationMeta) other;
            return kotlin.jvm.internal.p.d(this.name, animationMeta.name) && kotlin.jvm.internal.p.d(this.desc, animationMeta.desc);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.desc.hashCode();
        }

        public String toString() {
            return "AnimationMeta(name=" + this.name + ", desc=" + this.desc + ")";
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u000b\b\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0006B\u0015\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\u0007\u0082\u0001\u000b\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"LM4/e$c;", "", "", "linesArray", "<init>", "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "k", Const.INTENT_KEY_UMID, "f", "c", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LM4/e$c$a;", "LM4/e$c$b;", "LM4/e$c$c;", "LM4/e$c$d;", "LM4/e$c$e;", "LM4/e$c$f;", "LM4/e$c$g;", "LM4/e$c$h;", "LM4/e$c$i;", "LM4/e$c$j;", "LM4/e$c$k;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String linesArray;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"LM4/e$c$a;", "LM4/e$c;", "", "name", "linesArray", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$a, reason: from toString */
        public static final /* data */ class DrawableSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String name;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DrawableSpec(String name, String str) {
                super(str, null);
                kotlin.jvm.internal.p.i(name, "name");
                this.name = name;
                this.linesArray = str;
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            /* renamed from: c, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DrawableSpec)) {
                    return false;
                }
                DrawableSpec drawableSpec = (DrawableSpec) other;
                return kotlin.jvm.internal.p.d(this.name, drawableSpec.name) && kotlin.jvm.internal.p.d(this.linesArray, drawableSpec.linesArray);
            }

            public int hashCode() {
                int iHashCode = this.name.hashCode() * 31;
                String str = this.linesArray;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "DrawableSpec(name=" + this.name + ", linesArray=" + this.linesArray + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0018\u0010\n¨\u0006\u0019"}, d2 = {"LM4/e$c$c;", "LM4/e$c;", "", "html", "", "sandbox", "linesArray", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Z", Const.INTENT_KEY_UMID, "()Z", Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$c, reason: collision with other inner class name and from toString */
        public static final /* data */ class HtmlSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String html;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final boolean sandbox;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HtmlSpec(String html, boolean z10, String str) {
                super(str, null);
                kotlin.jvm.internal.p.i(html, "html");
                this.html = html;
                this.sandbox = z10;
                this.linesArray = str;
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            /* renamed from: c, reason: from getter */
            public final String getHtml() {
                return this.html;
            }

            /* renamed from: d, reason: from getter */
            public final boolean getSandbox() {
                return this.sandbox;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HtmlSpec)) {
                    return false;
                }
                HtmlSpec htmlSpec = (HtmlSpec) other;
                return kotlin.jvm.internal.p.d(this.html, htmlSpec.html) && this.sandbox == htmlSpec.sandbox && kotlin.jvm.internal.p.d(this.linesArray, htmlSpec.linesArray);
            }

            public int hashCode() {
                int iHashCode = ((this.html.hashCode() * 31) + Boolean.hashCode(this.sandbox)) * 31;
                String str = this.linesArray;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "HtmlSpec(html=" + this.html + ", sandbox=" + this.sandbox + ", linesArray=" + this.linesArray + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001c\u0010\f¨\u0006\u001d"}, d2 = {"LM4/e$c$d;", "LM4/e$c;", "", "rawName", "", "loop", "", Const.JSON_KEY_SPEED, "linesArray", "<init>", "(Ljava/lang/String;IFLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", "I", "F", "e", "()F", Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$d, reason: from toString */
        public static final /* data */ class LottieSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String rawName;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final int loop;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            public final float speed;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LottieSpec(String rawName, int i10, float f10, String str) {
                super(str, null);
                kotlin.jvm.internal.p.i(rawName, "rawName");
                this.rawName = rawName;
                this.loop = i10;
                this.speed = f10;
                this.linesArray = str;
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            /* renamed from: c, reason: from getter */
            public final int getLoop() {
                return this.loop;
            }

            /* renamed from: d, reason: from getter */
            public final String getRawName() {
                return this.rawName;
            }

            /* renamed from: e, reason: from getter */
            public final float getSpeed() {
                return this.speed;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LottieSpec)) {
                    return false;
                }
                LottieSpec lottieSpec = (LottieSpec) other;
                return kotlin.jvm.internal.p.d(this.rawName, lottieSpec.rawName) && this.loop == lottieSpec.loop && Float.compare(this.speed, lottieSpec.speed) == 0 && kotlin.jvm.internal.p.d(this.linesArray, lottieSpec.linesArray);
            }

            public int hashCode() {
                int iHashCode = ((((this.rawName.hashCode() * 31) + Integer.hashCode(this.loop)) * 31) + Float.hashCode(this.speed)) * 31;
                String str = this.linesArray;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "LottieSpec(rawName=" + this.rawName + ", loop=" + this.loop + ", speed=" + this.speed + ", linesArray=" + this.linesArray + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"LM4/e$c$e;", "LM4/e$c;", "", "md", "linesArray", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$e, reason: collision with other inner class name and from toString */
        public static final /* data */ class MarkdownSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String md;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MarkdownSpec(String md, String str) {
                super(str, null);
                kotlin.jvm.internal.p.i(md, "md");
                this.md = md;
                this.linesArray = str;
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            /* renamed from: c, reason: from getter */
            public final String getMd() {
                return this.md;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MarkdownSpec)) {
                    return false;
                }
                MarkdownSpec markdownSpec = (MarkdownSpec) other;
                return kotlin.jvm.internal.p.d(this.md, markdownSpec.md) && kotlin.jvm.internal.p.d(this.linesArray, markdownSpec.linesArray);
            }

            public int hashCode() {
                int iHashCode = this.md.hashCode() * 31;
                String str = this.linesArray;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "MarkdownSpec(md=" + this.md + ", linesArray=" + this.linesArray + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u001a\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b \u0010\r¨\u0006!"}, d2 = {"LM4/e$c$f;", "LM4/e$c;", "", "assetPath", "", "loop", "", Const.JSON_KEY_SPEED, "fps", "linesArray", "<init>", "(Ljava/lang/String;IFLjava/lang/Float;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "I", "e", Const.INTENT_KEY_UMID, "F", "f", "()F", "Ljava/lang/Float;", "()Ljava/lang/Float;", Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$f, reason: from toString */
        public static final /* data */ class PagSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String assetPath;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final int loop;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            public final float speed;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
            public final Float fps;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PagSpec(String assetPath, int i10, float f10, Float f11, String str) {
                super(str, null);
                kotlin.jvm.internal.p.i(assetPath, "assetPath");
                this.assetPath = assetPath;
                this.loop = i10;
                this.speed = f10;
                this.fps = f11;
                this.linesArray = str;
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            /* renamed from: c, reason: from getter */
            public final String getAssetPath() {
                return this.assetPath;
            }

            /* renamed from: d, reason: from getter */
            public final Float getFps() {
                return this.fps;
            }

            /* renamed from: e, reason: from getter */
            public final int getLoop() {
                return this.loop;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PagSpec)) {
                    return false;
                }
                PagSpec pagSpec = (PagSpec) other;
                return kotlin.jvm.internal.p.d(this.assetPath, pagSpec.assetPath) && this.loop == pagSpec.loop && Float.compare(this.speed, pagSpec.speed) == 0 && kotlin.jvm.internal.p.d(this.fps, pagSpec.fps) && kotlin.jvm.internal.p.d(this.linesArray, pagSpec.linesArray);
            }

            /* renamed from: f, reason: from getter */
            public final float getSpeed() {
                return this.speed;
            }

            public int hashCode() {
                int iHashCode = ((((this.assetPath.hashCode() * 31) + Integer.hashCode(this.loop)) * 31) + Float.hashCode(this.speed)) * 31;
                Float f10 = this.fps;
                int iHashCode2 = (iHashCode + (f10 == null ? 0 : f10.hashCode())) * 31;
                String str = this.linesArray;
                return iHashCode2 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                return "PagSpec(assetPath=" + this.assetPath + ", loop=" + this.loop + ", speed=" + this.speed + ", fps=" + this.fps + ", linesArray=" + this.linesArray + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"LM4/e$c$g;", "LM4/e$c;", "", "rawName", "linesArray", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$g, reason: from toString */
        public static final /* data */ class RawSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String rawName;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RawSpec(String rawName, String str) {
                super(str, null);
                kotlin.jvm.internal.p.i(rawName, "rawName");
                this.rawName = rawName;
                this.linesArray = str;
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            /* renamed from: c, reason: from getter */
            public final String getRawName() {
                return this.rawName;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RawSpec)) {
                    return false;
                }
                RawSpec rawSpec = (RawSpec) other;
                return kotlin.jvm.internal.p.d(this.rawName, rawSpec.rawName) && kotlin.jvm.internal.p.d(this.linesArray, rawSpec.linesArray);
            }

            public int hashCode() {
                int iHashCode = this.rawName.hashCode() * 31;
                String str = this.linesArray;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "RawSpec(rawName=" + this.rawName + ", linesArray=" + this.linesArray + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"LM4/e$c$h;", "LM4/e$c;", "", "url", "linesArray", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$h, reason: from toString */
        public static final /* data */ class RemoteImageSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String url;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RemoteImageSpec(String url, String str) {
                super(str, null);
                kotlin.jvm.internal.p.i(url, "url");
                this.url = url;
                this.linesArray = str;
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            /* renamed from: c, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RemoteImageSpec)) {
                    return false;
                }
                RemoteImageSpec remoteImageSpec = (RemoteImageSpec) other;
                return kotlin.jvm.internal.p.d(this.url, remoteImageSpec.url) && kotlin.jvm.internal.p.d(this.linesArray, remoteImageSpec.linesArray);
            }

            public int hashCode() {
                int iHashCode = this.url.hashCode() * 31;
                String str = this.linesArray;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "RemoteImageSpec(url=" + this.url + ", linesArray=" + this.linesArray + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"LM4/e$c$i;", "LM4/e$c;", "", "svg", "linesArray", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$i, reason: from toString */
        public static final /* data */ class RemoteSvgSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String svg;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RemoteSvgSpec(String svg, String str) {
                super(str, null);
                kotlin.jvm.internal.p.i(svg, "svg");
                this.svg = svg;
                this.linesArray = str;
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            /* renamed from: c, reason: from getter */
            public final String getSvg() {
                return this.svg;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RemoteSvgSpec)) {
                    return false;
                }
                RemoteSvgSpec remoteSvgSpec = (RemoteSvgSpec) other;
                return kotlin.jvm.internal.p.d(this.svg, remoteSvgSpec.svg) && kotlin.jvm.internal.p.d(this.linesArray, remoteSvgSpec.linesArray);
            }

            public int hashCode() {
                int iHashCode = this.svg.hashCode() * 31;
                String str = this.linesArray;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "RemoteSvgSpec(svg=" + this.svg + ", linesArray=" + this.linesArray + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001c\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001e\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001f\u0010\u000e¨\u0006 "}, d2 = {"LM4/e$c$j;", "LM4/e$c;", "", "drawableName", "", "columns", "rows", "frameCount", "fps", "loop", "linesArray", "<init>", "(Ljava/lang/String;IIIIILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$j, reason: from toString */
        public static final /* data */ class SpriteSheetSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String drawableName;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final int columns;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            public final int rows;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
            public final int frameCount;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
            public final int fps;

            /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
            public final int loop;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SpriteSheetSpec(String drawableName, int i10, int i11, int i12, int i13, int i14, String str) {
                super(str, null);
                kotlin.jvm.internal.p.i(drawableName, "drawableName");
                this.drawableName = drawableName;
                this.columns = i10;
                this.rows = i11;
                this.frameCount = i12;
                this.fps = i13;
                this.loop = i14;
                this.linesArray = str;
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            /* renamed from: c, reason: from getter */
            public final int getColumns() {
                return this.columns;
            }

            /* renamed from: d, reason: from getter */
            public final String getDrawableName() {
                return this.drawableName;
            }

            /* renamed from: e, reason: from getter */
            public final int getFps() {
                return this.fps;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SpriteSheetSpec)) {
                    return false;
                }
                SpriteSheetSpec spriteSheetSpec = (SpriteSheetSpec) other;
                return kotlin.jvm.internal.p.d(this.drawableName, spriteSheetSpec.drawableName) && this.columns == spriteSheetSpec.columns && this.rows == spriteSheetSpec.rows && this.frameCount == spriteSheetSpec.frameCount && this.fps == spriteSheetSpec.fps && this.loop == spriteSheetSpec.loop && kotlin.jvm.internal.p.d(this.linesArray, spriteSheetSpec.linesArray);
            }

            /* renamed from: f, reason: from getter */
            public final int getFrameCount() {
                return this.frameCount;
            }

            /* renamed from: g, reason: from getter */
            public final int getLoop() {
                return this.loop;
            }

            /* renamed from: h, reason: from getter */
            public final int getRows() {
                return this.rows;
            }

            public int hashCode() {
                int iHashCode = ((((((((((this.drawableName.hashCode() * 31) + Integer.hashCode(this.columns)) * 31) + Integer.hashCode(this.rows)) * 31) + Integer.hashCode(this.frameCount)) * 31) + Integer.hashCode(this.fps)) * 31) + Integer.hashCode(this.loop)) * 31;
                String str = this.linesArray;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "SpriteSheetSpec(drawableName=" + this.drawableName + ", columns=" + this.columns + ", rows=" + this.rows + ", frameCount=" + this.frameCount + ", fps=" + this.fps + ", loop=" + this.loop + ", linesArray=" + this.linesArray + ")";
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\"\u0010\u0012R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b&\u0010\u0012R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b$\u0010#\u001a\u0004\b'\u0010%R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b(\u0010%R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b'\u0010)\u001a\u0004\b\u001e\u0010*R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b+\u0010\u0012¨\u0006,"}, d2 = {"LM4/e$c$k;", "LM4/e$c;", "", "arrayName", "Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;", "tileMode", "colorHex", "", "fontSizeSp", "fontResName", "lineHeightEm", "letterSpacingEm", "Lcom/stepos/agentsprite/SceneLayerSpec$Anchor;", LinkHeader.Parameters.Anchor, "linesArray", "<init>", "(Ljava/lang/String;Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Lcom/stepos/agentsprite/SceneLayerSpec$Anchor;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", "Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;", "e", "Ljava/lang/Float;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Float;", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/agentsprite/SceneLayerSpec$Anchor;", "()Lcom/stepos/agentsprite/SceneLayerSpec$Anchor;", Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$k, reason: from toString */
        public static final /* data */ class TextSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final String arrayName;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final SceneLayerSpec.TileMode tileMode;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            public final String colorHex;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
            public final Float fontSizeSp;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
            public final String fontResName;

            /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
            public final Float lineHeightEm;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
            public final Float letterSpacingEm;

            /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
            public final SceneLayerSpec.Anchor anchor;

            /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TextSpec(String arrayName, SceneLayerSpec.TileMode tileMode, String str, Float f10, String str2, Float f11, Float f12, SceneLayerSpec.Anchor anchor, String str3) {
                super(str3, null);
                kotlin.jvm.internal.p.i(arrayName, "arrayName");
                kotlin.jvm.internal.p.i(tileMode, "tileMode");
                this.arrayName = arrayName;
                this.tileMode = tileMode;
                this.colorHex = str;
                this.fontSizeSp = f10;
                this.fontResName = str2;
                this.lineHeightEm = f11;
                this.letterSpacingEm = f12;
                this.anchor = anchor;
                this.linesArray = str3;
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            /* renamed from: c, reason: from getter */
            public final SceneLayerSpec.Anchor getAnchor() {
                return this.anchor;
            }

            /* renamed from: d, reason: from getter */
            public final String getArrayName() {
                return this.arrayName;
            }

            /* renamed from: e, reason: from getter */
            public final String getColorHex() {
                return this.colorHex;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TextSpec)) {
                    return false;
                }
                TextSpec textSpec = (TextSpec) other;
                return kotlin.jvm.internal.p.d(this.arrayName, textSpec.arrayName) && this.tileMode == textSpec.tileMode && kotlin.jvm.internal.p.d(this.colorHex, textSpec.colorHex) && kotlin.jvm.internal.p.d(this.fontSizeSp, textSpec.fontSizeSp) && kotlin.jvm.internal.p.d(this.fontResName, textSpec.fontResName) && kotlin.jvm.internal.p.d(this.lineHeightEm, textSpec.lineHeightEm) && kotlin.jvm.internal.p.d(this.letterSpacingEm, textSpec.letterSpacingEm) && this.anchor == textSpec.anchor && kotlin.jvm.internal.p.d(this.linesArray, textSpec.linesArray);
            }

            /* renamed from: f, reason: from getter */
            public final String getFontResName() {
                return this.fontResName;
            }

            /* renamed from: g, reason: from getter */
            public final Float getFontSizeSp() {
                return this.fontSizeSp;
            }

            /* renamed from: h, reason: from getter */
            public final Float getLetterSpacingEm() {
                return this.letterSpacingEm;
            }

            public int hashCode() {
                int iHashCode = ((this.arrayName.hashCode() * 31) + this.tileMode.hashCode()) * 31;
                String str = this.colorHex;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                Float f10 = this.fontSizeSp;
                int iHashCode3 = (iHashCode2 + (f10 == null ? 0 : f10.hashCode())) * 31;
                String str2 = this.fontResName;
                int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
                Float f11 = this.lineHeightEm;
                int iHashCode5 = (iHashCode4 + (f11 == null ? 0 : f11.hashCode())) * 31;
                Float f12 = this.letterSpacingEm;
                int iHashCode6 = (iHashCode5 + (f12 == null ? 0 : f12.hashCode())) * 31;
                SceneLayerSpec.Anchor anchor = this.anchor;
                int iHashCode7 = (iHashCode6 + (anchor == null ? 0 : anchor.hashCode())) * 31;
                String str3 = this.linesArray;
                return iHashCode7 + (str3 != null ? str3.hashCode() : 0);
            }

            /* renamed from: i, reason: from getter */
            public final Float getLineHeightEm() {
                return this.lineHeightEm;
            }

            /* renamed from: j, reason: from getter */
            public final SceneLayerSpec.TileMode getTileMode() {
                return this.tileMode;
            }

            public String toString() {
                return "TextSpec(arrayName=" + this.arrayName + ", tileMode=" + this.tileMode + ", colorHex=" + this.colorHex + ", fontSizeSp=" + this.fontSizeSp + ", fontResName=" + this.fontResName + ", lineHeightEm=" + this.lineHeightEm + ", letterSpacingEm=" + this.letterSpacingEm + ", anchor=" + this.anchor + ", linesArray=" + this.linesArray + ")";
            }
        }

        public /* synthetic */ c(String str, kotlin.jvm.internal.i iVar) {
            this(str);
        }

        /* renamed from: a, reason: from getter */
        public String getLinesArray() {
            return this.linesArray;
        }

        public final String b() {
            if (this instanceof PagSpec) {
                String strT0 = H.T0(H.s1(((PagSpec) this).getAssetPath(), JsonPointer.SEPARATOR, null, 2, null), ".pag");
                if (strT0.length() > 0) {
                    return strT0;
                }
                return null;
            }
            if (this instanceof FramesSpec) {
                FramesSpec framesSpec = (FramesSpec) this;
                String frameArrayName = framesSpec.getFrameArrayName();
                if (frameArrayName != null) {
                    String str = frameArrayName.length() > 0 ? frameArrayName : null;
                    if (str != null) {
                        return str;
                    }
                }
                return (String) F.s0(framesSpec.c());
            }
            if (this instanceof DrawableSpec) {
                String name = ((DrawableSpec) this).getName();
                if (name.length() > 0) {
                    return name;
                }
                return null;
            }
            if (this instanceof LottieSpec) {
                String rawName = ((LottieSpec) this).getRawName();
                if (rawName.length() > 0) {
                    return rawName;
                }
                return null;
            }
            if (this instanceof SpriteSheetSpec) {
                String drawableName = ((SpriteSheetSpec) this).getDrawableName();
                if (drawableName.length() > 0) {
                    return drawableName;
                }
                return null;
            }
            if (this instanceof RawSpec) {
                String rawName2 = ((RawSpec) this).getRawName();
                if (rawName2.length() > 0) {
                    return rawName2;
                }
            }
            return null;
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\r¨\u0006\u001f"}, d2 = {"LM4/e$c$b;", "LM4/e$c;", "", "", "drawableNames", "frameArrayName", "", "fps", "loop", "linesArray", "<init>", "(Ljava/util/List;Ljava/lang/String;IILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "c", "()Ljava/util/List;", "Ljava/lang/String;", "e", Const.INTENT_KEY_UMID, "I", "f", Const.INTENT_KEY_APIKEY, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: M4.e$c$b, reason: from toString */
        public static final /* data */ class FramesSpec extends c {

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final List<String> drawableNames;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            public final String frameArrayName;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            public final int fps;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
            public final int loop;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
            public final String linesArray;

            /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
                java.lang.NullPointerException
                */
            public /* synthetic */ FramesSpec(java.util.List r2, java.lang.String r3, int r4, int r5, java.lang.String r6, int r7, kotlin.jvm.internal.i r8) {
                /*
                    r1 = this;
                    r8 = r7 & 1
                    if (r8 == 0) goto L8
                    java.util.List r2 = Z8.C1173v.m()
                L8:
                    r8 = r7 & 2
                    r0 = 0
                    if (r8 == 0) goto Le
                    r3 = r0
                Le:
                    r7 = r7 & 16
                    if (r7 == 0) goto L19
                    r8 = r0
                    r6 = r4
                    r7 = r5
                    r4 = r2
                    r5 = r3
                    r3 = r1
                    goto L1f
                L19:
                    r8 = r6
                    r7 = r5
                    r5 = r3
                    r6 = r4
                    r3 = r1
                    r4 = r2
                L1f:
                    r3.<init>(r4, r5, r6, r7, r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: M4.e.c.FramesSpec.<init>(java.util.List, java.lang.String, int, int, java.lang.String, int, kotlin.jvm.internal.i):void");
            }

            @Override // M4.e.c
            /* renamed from: a, reason: from getter */
            public String getLinesArray() {
                return this.linesArray;
            }

            public final List<String> c() {
                return this.drawableNames;
            }

            /* renamed from: d, reason: from getter */
            public final int getFps() {
                return this.fps;
            }

            /* renamed from: e, reason: from getter */
            public final String getFrameArrayName() {
                return this.frameArrayName;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FramesSpec)) {
                    return false;
                }
                FramesSpec framesSpec = (FramesSpec) other;
                return kotlin.jvm.internal.p.d(this.drawableNames, framesSpec.drawableNames) && kotlin.jvm.internal.p.d(this.frameArrayName, framesSpec.frameArrayName) && this.fps == framesSpec.fps && this.loop == framesSpec.loop && kotlin.jvm.internal.p.d(this.linesArray, framesSpec.linesArray);
            }

            /* renamed from: f, reason: from getter */
            public final int getLoop() {
                return this.loop;
            }

            public int hashCode() {
                int iHashCode = this.drawableNames.hashCode() * 31;
                String str = this.frameArrayName;
                int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.fps)) * 31) + Integer.hashCode(this.loop)) * 31;
                String str2 = this.linesArray;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "FramesSpec(drawableNames=" + this.drawableNames + ", frameArrayName=" + this.frameArrayName + ", fps=" + this.fps + ", loop=" + this.loop + ", linesArray=" + this.linesArray + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FramesSpec(List<String> drawableNames, String str, int i10, int i11, String str2) {
                super(str2, null);
                kotlin.jvm.internal.p.i(drawableNames, "drawableNames");
                this.drawableNames = drawableNames;
                this.frameArrayName = str;
                this.fps = i10;
                this.loop = i11;
                this.linesArray = str2;
            }
        }

        public c(String str) {
            this.linesArray = str;
        }
    }

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\u0012*\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u0015J!\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u0012*\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001f\u0010\u0015J\u001b\u0010!\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020#0\u0012*\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b$\u0010\u0015J\u001b\u0010%\u001a\u0004\u0018\u00010#2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0'2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0004\b,\u0010-J#\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010 \u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u0002022\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b3\u00104J\u001b\u00106\u001a\u0004\u0018\u0001052\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b6\u00107R\u0014\u00108\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010;\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00109¨\u0006<"}, d2 = {"LM4/e$d;", "", "<init>", "()V", "Landroid/content/res/Resources;", "resources", "", "packageName", "LM4/e;", "c", "(Landroid/content/res/Resources;Ljava/lang/String;)LM4/e;", "json", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)LM4/e;", Const.INTENT_KEY_APIKEY, "()LM4/e;", "Lorg/json/JSONObject;", "entryObj", "", "LM4/e$f;", "n", "(Lorg/json/JSONObject;)Ljava/util/Map;", "", Const.INTENT_KEY_PKGNAME, "(Lorg/json/JSONObject;)Z", "obj", "m", "(Lorg/json/JSONObject;)LM4/e$f;", "LM4/e$g;", "o", "LM4/e$c;", "f", "raw", "p", "(Ljava/lang/Object;)LM4/e$g;", "LM4/e$e;", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Object;)LM4/e$e;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Object;)Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)LM4/e$c;", "l", "(Lorg/json/JSONObject;)LM4/e$c;", "lines", "LM4/e$c$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lorg/json/JSONObject;Ljava/lang/String;)LM4/e$c$b;", "Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;", "q", "(Ljava/lang/String;)Lcom/stepos/agentsprite/SceneLayerSpec$TileMode;", "Lcom/stepos/agentsprite/SceneLayerSpec$Anchor;", "e", "(Ljava/lang/String;)Lcom/stepos/agentsprite/SceneLayerSpec$Anchor;", "DEFAULT_SKIN", "Ljava/lang/String;", "MANIFEST_NAME", "MANIFEST_TYPE", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: M4.e$d, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final e a() {
            return new e(kotlin.collections.a.i(), null);
        }

        public final boolean b(JSONObject jSONObject) {
            return jSONObject.has("states") || jSONObject.has("emotions") || jSONObject.has("places") || jSONObject.has(O5.c.WEATHER);
        }

        public final e c(Resources resources, String packageName) {
            Object objB;
            Object objB2;
            Object objB3;
            kotlin.jvm.internal.p.i(resources, "resources");
            kotlin.jvm.internal.p.i(packageName, "packageName");
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(Integer.valueOf(resources.getIdentifier("agent_manifest", "raw", packageName)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = 0;
            }
            int iIntValue = ((Number) objB).intValue();
            if (iIntValue == 0) {
                return a();
            }
            try {
                InputStream inputStreamOpenRawResource = resources.openRawResource(iIntValue);
                kotlin.jvm.internal.p.h(inputStreamOpenRawResource, "openRawResource(...)");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, C0953c.UTF_8), com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
                try {
                    String strE = l9.m.e(bufferedReader);
                    l9.b.a(bufferedReader, null);
                    objB2 = Result.b(strE);
                } finally {
                }
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            if (Result.h(objB2)) {
                try {
                    objB3 = Result.b(e.INSTANCE.d((String) objB2));
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objB2 = C4849c.a(th3);
                }
            } else {
                objB3 = Result.b(objB2);
            }
            e eVarA = a();
            if (Result.g(objB3)) {
                objB3 = eVarA;
            }
            return (e) objB3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final e d(String json) {
            kotlin.jvm.internal.p.i(json, "json");
            JSONObject jSONObjectOptJSONObject = new JSONObject(json).optJSONObject("agents");
            if (jSONObjectOptJSONObject == null) {
                return a();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (true) {
                Object[] objArr = 0;
                if (!itKeys.hasNext()) {
                    return new e(linkedHashMap, objArr == true ? 1 : 0);
                }
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString = jSONObjectOptJSONObject2.optString("fallback");
                    kotlin.jvm.internal.p.f(strOptString);
                    String str = strOptString.length() > 0 ? strOptString : null;
                    if (str != null) {
                        Map<String, f> mapN = n(jSONObjectOptJSONObject2);
                        if (!mapN.isEmpty()) {
                            linkedHashMap.put(next, new a(mapN, str));
                        }
                    }
                }
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x012a, code lost:
        
            return com.stepos.agentsprite.SceneLayerSpec.Anchor.BottomLeft;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x0131, code lost:
        
            if (r2.equals("bottom_right") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0136, code lost:
        
            return com.stepos.agentsprite.SceneLayerSpec.Anchor.BottomRight;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        
            if (r2.equals("centerstart") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        
            if (r2.equals("topcenter") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        
            if (r2.equals("top_right") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        
            if (r2.equals("right") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
        
            if (r2.equals("left") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
        
            if (r2.equals("top") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
        
            if (r2.equals("tr") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        
            if (r2.equals("tl") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
        
            if (r2.equals("tc") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0077, code lost:
        
            return com.stepos.agentsprite.SceneLayerSpec.Anchor.TopCenter;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007e, code lost:
        
            if (r2.equals("cs") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0084, code lost:
        
            return com.stepos.agentsprite.SceneLayerSpec.Anchor.CenterStart;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
        
            if (r2.equals("ce") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0095, code lost:
        
            if (r2.equals("br") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x009f, code lost:
        
            if (r2.equals("bl") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a9, code lost:
        
            if (r2.equals("bc") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b3, code lost:
        
            if (r2.equals("c") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c4, code lost:
        
            if (r2.equals("bottomright") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00ce, code lost:
        
            if (r2.equals("bottom_left") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00d7, code lost:
        
            if (r2.equals("centerend") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00dc, code lost:
        
            return com.stepos.agentsprite.SceneLayerSpec.Anchor.CenterEnd;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00e3, code lost:
        
            if (r2.equals("topright") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x00e8, code lost:
        
            return com.stepos.agentsprite.SceneLayerSpec.Anchor.TopRight;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x00ef, code lost:
        
            if (r2.equals("top_left") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x00f8, code lost:
        
            if (r2.equals("topleft") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x00fd, code lost:
        
            return com.stepos.agentsprite.SceneLayerSpec.Anchor.TopLeft;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0104, code lost:
        
            if (r2.equals("center") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0109, code lost:
        
            return com.stepos.agentsprite.SceneLayerSpec.Anchor.Center;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0110, code lost:
        
            if (r2.equals("bottom") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0119, code lost:
        
            if (r2.equals("bottomcenter") == false) goto L104;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x011e, code lost:
        
            return com.stepos.agentsprite.SceneLayerSpec.Anchor.BottomCenter;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0125, code lost:
        
            if (r2.equals("bottomleft") == false) goto L104;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.stepos.agentsprite.SceneLayerSpec.Anchor e(java.lang.String r2) {
            /*
                Method dump skipped, instructions count: 422
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: M4.e.Companion.e(java.lang.String):com.stepos.agentsprite.SceneLayerSpec$Anchor");
        }

        public final Map<String, c> f(JSONObject jSONObject) {
            c cVarG;
            if (jSONObject == null) {
                return kotlin.collections.a.i();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                kotlin.jvm.internal.p.f(next);
                if (!D.X(next, "_", false, 2, null) && (cVarG = g(jSONObject.opt(next))) != null) {
                    linkedHashMap.put(next, cVarG);
                }
            }
            return linkedHashMap;
        }

        public final c g(Object raw) {
            if (raw != null && !kotlin.jvm.internal.p.d(raw, JSONObject.NULL)) {
                if (raw instanceof String) {
                    return new c.DrawableSpec((String) raw, null);
                }
                if (raw instanceof JSONObject) {
                    return l((JSONObject) raw);
                }
            }
            return null;
        }

        public final List<c> h(Object raw) {
            if (raw == null || kotlin.jvm.internal.p.d(raw, JSONObject.NULL)) {
                return C1173v.m();
            }
            if (!(raw instanceof JSONArray)) {
                return C1173v.q(g(raw));
            }
            JSONArray jSONArray = (JSONArray) raw;
            ArrayList arrayList = new ArrayList(jSONArray.length());
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                c cVarG = g(jSONArray.opt(i10));
                if (cVarG != null) {
                    arrayList.add(cVarG);
                }
            }
            return arrayList;
        }

        public final c.FramesSpec i(JSONObject raw, String lines) {
            if (raw.has("frames") && !raw.isNull("frames")) {
                int iF = C5685n.f(raw.optInt("fps", 24), 1);
                int iC = l.c(raw, 0, 2, null);
                Object objOpt = raw.opt("frames");
                if (!(objOpt instanceof JSONArray)) {
                    if (!(objOpt instanceof String) || ((CharSequence) objOpt).length() == 0) {
                        return null;
                    }
                    return new c.FramesSpec(null, (String) objOpt, iF, iC, lines, 1, null);
                }
                JSONArray jSONArray = (JSONArray) objOpt;
                C5680i c5680iS = C5685n.s(0, jSONArray.length());
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = c5680iS.iterator();
                while (it.hasNext()) {
                    String strOptString = jSONArray.optString(((M) it).nextInt());
                    kotlin.jvm.internal.p.f(strOptString);
                    if (strOptString.length() <= 0) {
                        strOptString = null;
                    }
                    if (strOptString != null) {
                        arrayList.add(strOptString);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new c.FramesSpec(arrayList, null, iF, iC, lines, 2, null);
            }
            return null;
        }

        public final C0082e j(Object raw) {
            if (raw != null && !kotlin.jvm.internal.p.d(raw, JSONObject.NULL)) {
                if (raw instanceof String) {
                    return new C0082e(C1173v.m(), C1173v.m(), null, null, null, false, 60, null);
                }
                if (raw instanceof JSONArray) {
                    return new C0082e(C1173v.m(), h(raw), null, null, null, false, 60, null);
                }
                if (raw instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) raw;
                    String strOptString = jSONObject.optString("renderer");
                    kotlin.jvm.internal.p.f(strOptString);
                    String str = strOptString.length() > 0 ? strOptString : null;
                    String strOptString2 = jSONObject.optString("entry");
                    kotlin.jvm.internal.p.f(strOptString2);
                    String str2 = strOptString2.length() > 0 ? strOptString2 : null;
                    boolean zOptBoolean = jSONObject.optBoolean("sandbox", true);
                    Map<String, StateSpec> mapO = o(jSONObject.optJSONObject("states"));
                    if (str != null) {
                        return new C0082e(C1173v.m(), h(jSONObject.opt(com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND)), mapO, str, str2, zOptBoolean);
                    }
                    if (!mapO.isEmpty()) {
                        return new C0082e(C1173v.m(), h(jSONObject.opt(com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND)), mapO, null, null, false, 56, null);
                    }
                    if (jSONObject.has(com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND)) {
                        return new C0082e(C1173v.m(), h(jSONObject.opt(com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND)), null, null, null, false, 60, null);
                    }
                    return new C0082e(C1173v.m(), C1173v.m(), null, null, null, false, 60, null);
                }
            }
            return null;
        }

        public final Map<String, C0082e> k(JSONObject jSONObject) {
            C0082e c0082eJ;
            if (jSONObject == null) {
                return kotlin.collections.a.i();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                kotlin.jvm.internal.p.f(next);
                if (!D.X(next, "_", false, 2, null) && (c0082eJ = j(jSONObject.opt(next))) != null) {
                    linkedHashMap.put(next, c0082eJ);
                }
            }
            return linkedHashMap;
        }

        public final c l(JSONObject raw) {
            String strOptString = raw.optString("lines");
            kotlin.jvm.internal.p.f(strOptString);
            String str = strOptString.length() > 0 ? strOptString : null;
            String strOptString2 = raw.optString("sprite_sheet");
            kotlin.jvm.internal.p.f(strOptString2);
            String str2 = strOptString2.length() > 0 ? strOptString2 : null;
            if (str2 != null) {
                int iOptInt = raw.optInt("columns", 0);
                int iOptInt2 = raw.optInt("rows", 0);
                if (iOptInt <= 0 || iOptInt2 <= 0) {
                    return null;
                }
                int i10 = iOptInt * iOptInt2;
                return new c.SpriteSheetSpec(str2, iOptInt, iOptInt2, C5685n.j(C5685n.f(raw.optInt("frameCount", i10), 1), i10), C5685n.f(raw.optInt("fps", 24), 1), l.c(raw, 0, 2, null), str);
            }
            c.FramesSpec framesSpecI = i(raw, str);
            if (framesSpecI != null) {
                return framesSpecI;
            }
            String strOptString3 = raw.optString("text");
            kotlin.jvm.internal.p.f(strOptString3);
            String str3 = strOptString3.length() > 0 ? strOptString3 : null;
            if (str3 != null) {
                Companion companion = e.INSTANCE;
                SceneLayerSpec.TileMode tileModeQ = companion.q(raw.optString("tileMode"));
                String strOptString4 = raw.optString("color");
                kotlin.jvm.internal.p.f(strOptString4);
                String str4 = strOptString4.length() > 0 ? strOptString4 : null;
                Float fValueOf = Float.valueOf((float) raw.optDouble("fontSizeSp", 0.0d));
                Float f10 = fValueOf.floatValue() > 0.0f ? fValueOf : null;
                String strOptString5 = raw.optString(ContentType.Font.TYPE);
                kotlin.jvm.internal.p.f(strOptString5);
                if (strOptString5.length() <= 0) {
                    strOptString5 = null;
                }
                Float fValueOf2 = Float.valueOf((float) raw.optDouble("lineHeightEm", 0.0d));
                Float f11 = fValueOf2.floatValue() > 0.0f ? fValueOf2 : null;
                Float fValueOf3 = Float.valueOf((float) raw.optDouble("letterSpacingEm", Double.NaN));
                return new c.TextSpec(str3, tileModeQ, str4, f10, strOptString5, f11, !Float.isNaN(fValueOf3.floatValue()) ? fValueOf3 : null, companion.e(raw.optString(LinkHeader.Parameters.Anchor)), str);
            }
            String strOptString6 = raw.optString("lottie");
            kotlin.jvm.internal.p.f(strOptString6);
            if (strOptString6.length() <= 0) {
                strOptString6 = null;
            }
            if (strOptString6 != null) {
                return new c.LottieSpec(strOptString6, l.c(raw, 0, 2, null), (float) raw.optDouble(Const.JSON_KEY_SPEED, 1.0d), str);
            }
            String strOptString7 = raw.optString("pag");
            kotlin.jvm.internal.p.f(strOptString7);
            if (strOptString7.length() <= 0) {
                strOptString7 = null;
            }
            if (strOptString7 != null) {
                return new c.PagSpec(strOptString7, l.c(raw, 0, 2, null), (float) raw.optDouble(Const.JSON_KEY_SPEED, 1.0d), l.d(raw), str);
            }
            String strOptString8 = raw.optString("html");
            kotlin.jvm.internal.p.f(strOptString8);
            if (strOptString8.length() <= 0) {
                strOptString8 = null;
            }
            if (strOptString8 != null) {
                return new c.HtmlSpec(strOptString8, raw.optBoolean("sandbox", true), str);
            }
            String strOptString9 = raw.optString("markdown");
            kotlin.jvm.internal.p.f(strOptString9);
            if (strOptString9.length() <= 0) {
                strOptString9 = null;
            }
            if (strOptString9 != null) {
                return new c.MarkdownSpec(strOptString9, str);
            }
            String strOptString10 = raw.optString("svg");
            kotlin.jvm.internal.p.f(strOptString10);
            if (strOptString10.length() <= 0) {
                strOptString10 = null;
            }
            if (strOptString10 != null) {
                return new c.RemoteSvgSpec(strOptString10, str);
            }
            String strOptString11 = raw.optString("image_url");
            kotlin.jvm.internal.p.f(strOptString11);
            if (strOptString11.length() <= 0) {
                strOptString11 = null;
            }
            if (strOptString11 != null) {
                return new c.RemoteImageSpec(strOptString11, str);
            }
            String strOptString12 = raw.optString("raw");
            kotlin.jvm.internal.p.f(strOptString12);
            if (strOptString12.length() <= 0) {
                strOptString12 = null;
            }
            if (strOptString12 != null) {
                return new c.RawSpec(strOptString12, str);
            }
            String strOptString13 = raw.optString("drawable");
            kotlin.jvm.internal.p.f(strOptString13);
            if (strOptString13.length() <= 0) {
                strOptString13 = null;
            }
            if (strOptString13 == null) {
                return null;
            }
            return new c.DrawableSpec(strOptString13, str);
        }

        public final f m(JSONObject obj) {
            Map<String, StateSpec> mapO = o(obj.optJSONObject("states"));
            Map<String, c> mapF = f(obj.optJSONObject("emotions"));
            Map<String, C0082e> mapK = k(obj.optJSONObject("places"));
            Map<String, C0082e> mapK2 = k(obj.optJSONObject(O5.c.WEATHER));
            String strOptString = obj.optString("inheritFrom");
            kotlin.jvm.internal.p.f(strOptString);
            String str = strOptString.length() > 0 ? strOptString : null;
            String strOptString2 = obj.optString("fallback");
            kotlin.jvm.internal.p.f(strOptString2);
            return new f(mapO, mapF, mapK, mapK2, str, strOptString2.length() > 0 ? strOptString2 : null);
        }

        public final Map<String, f> n(JSONObject entryObj) {
            JSONObject jSONObjectOptJSONObject = entryObj.optJSONObject("skins");
            if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) {
                return Q.f(Y8.j.a("default", m(entryObj)));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject2 != null) {
                    linkedHashMap.put(next, m(jSONObjectOptJSONObject2));
                }
            }
            if (!linkedHashMap.containsKey("default") && b(entryObj)) {
                linkedHashMap.put("default", m(entryObj));
            }
            return linkedHashMap;
        }

        public final Map<String, StateSpec> o(JSONObject jSONObject) {
            StateSpec stateSpecP;
            if (jSONObject == null) {
                return kotlin.collections.a.i();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                kotlin.jvm.internal.p.f(next);
                if (!D.X(next, "_", false, 2, null) && (stateSpecP = p(jSONObject.opt(next))) != null) {
                    linkedHashMap.put(next, stateSpecP);
                }
            }
            return linkedHashMap;
        }

        public final StateSpec p(Object raw) {
            Object objOpt;
            c cVarG;
            AnimationMeta animationMeta = null;
            JSONObject jSONObject = raw instanceof JSONObject ? (JSONObject) raw : null;
            if (jSONObject == null || (objOpt = jSONObject.opt("body")) == null || kotlin.jvm.internal.p.d(objOpt, JSONObject.NULL) || (cVarG = g(objOpt)) == null) {
                return null;
            }
            List<c> listH = h(jSONObject.opt("background"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("meta");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("name");
                kotlin.jvm.internal.p.h(strOptString, "optString(...)");
                String strOptString2 = jSONObjectOptJSONObject.optString(Const.JSON_KEY_DESC);
                kotlin.jvm.internal.p.h(strOptString2, "optString(...)");
                animationMeta = new AnimationMeta(strOptString, strOptString2);
            }
            return new StateSpec(listH, cVarG, animationMeta);
        }

        public final SceneLayerSpec.TileMode q(String raw) {
            String lowerCase;
            if (raw != null) {
                lowerCase = raw.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            return kotlin.jvm.internal.p.d(lowerCase, M5.c.DOWNLOAD_SINGLE) ? SceneLayerSpec.TileMode.Single : SceneLayerSpec.TileMode.Repeat;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001Bk\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0002\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0014\u0010\u0018R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018¨\u0006\u001a"}, d2 = {"LM4/e$f;", "", "", "", "LM4/e$g;", "states", "LM4/e$c;", "emotions", "LM4/e$e;", "places", O5.c.WEATHER, "inheritFrom", "fallback", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", "e", "()Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, "getWeather", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Map<String, StateSpec> states;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Map<String, c> emotions;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final Map<String, C0082e> places;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final Map<String, C0082e> weather;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final String inheritFrom;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final String fallback;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Map<String, StateSpec> states, Map<String, ? extends c> emotions, Map<String, C0082e> places, Map<String, C0082e> weather, String str, String str2) {
            kotlin.jvm.internal.p.i(states, "states");
            kotlin.jvm.internal.p.i(emotions, "emotions");
            kotlin.jvm.internal.p.i(places, "places");
            kotlin.jvm.internal.p.i(weather, "weather");
            this.states = states;
            this.emotions = emotions;
            this.places = places;
            this.weather = weather;
            this.inheritFrom = str;
            this.fallback = str2;
        }

        public final Map<String, c> a() {
            return this.emotions;
        }

        /* renamed from: b, reason: from getter */
        public final String getFallback() {
            return this.fallback;
        }

        /* renamed from: c, reason: from getter */
        public final String getInheritFrom() {
            return this.inheritFrom;
        }

        public final Map<String, C0082e> d() {
            return this.places;
        }

        public final Map<String, StateSpec> e() {
            return this.states;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0018\u0010\u001d¨\u0006\u001e"}, d2 = {"LM4/e$g;", "", "", "LM4/e$c;", "background", "body", "LM4/e$b;", "meta", "<init>", "(Ljava/util/List;LM4/e$c;LM4/e$b;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "getBackground", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "LM4/e$c;", "()LM4/e$c;", "c", "LM4/e$b;", "()LM4/e$b;", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: M4.e$g, reason: from toString */
    public static final /* data */ class StateSpec {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<c> background;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final c body;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final AnimationMeta meta;

        /* JADX WARN: Multi-variable type inference failed */
        public StateSpec(List<? extends c> background, c body, AnimationMeta animationMeta) {
            kotlin.jvm.internal.p.i(background, "background");
            kotlin.jvm.internal.p.i(body, "body");
            this.background = background;
            this.body = body;
            this.meta = animationMeta;
        }

        /* renamed from: a, reason: from getter */
        public final c getBody() {
            return this.body;
        }

        /* renamed from: b, reason: from getter */
        public final AnimationMeta getMeta() {
            return this.meta;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateSpec)) {
                return false;
            }
            StateSpec stateSpec = (StateSpec) other;
            return kotlin.jvm.internal.p.d(this.background, stateSpec.background) && kotlin.jvm.internal.p.d(this.body, stateSpec.body) && kotlin.jvm.internal.p.d(this.meta, stateSpec.meta);
        }

        public int hashCode() {
            int iHashCode = ((this.background.hashCode() * 31) + this.body.hashCode()) * 31;
            AnimationMeta animationMeta = this.meta;
            return iHashCode + (animationMeta == null ? 0 : animationMeta.hashCode());
        }

        public String toString() {
            return "StateSpec(background=" + this.background + ", body=" + this.body + ", meta=" + this.meta + ")";
        }
    }

    public /* synthetic */ e(Map map, kotlin.jvm.internal.i iVar) {
        this(map);
    }

    public final String a(String agentId, String skinKey, String emotionKey) {
        c.DrawableSpec drawableSpec;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(skinKey, "skinKey");
        kotlin.jvm.internal.p.i(emotionKey, "emotionKey");
        a aVar = this.agents.get(agentId);
        if (aVar == null) {
            drawableSpec = null;
        } else {
            Iterator<String> it = d(agentId, skinKey).iterator();
            while (it.hasNext()) {
                f fVar = aVar.b().get(it.next());
                if (fVar != null) {
                    c cVar = fVar.a().get(emotionKey);
                    drawableSpec = cVar instanceof c.DrawableSpec ? (c.DrawableSpec) cVar : null;
                    if (drawableSpec != null) {
                        break;
                    }
                }
            }
            drawableSpec = null;
        }
        if (drawableSpec != null) {
            return drawableSpec.getName();
        }
        return null;
    }

    public final c b(String agentId, String skinKey, String emotionKey) {
        c cVar;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(skinKey, "skinKey");
        kotlin.jvm.internal.p.i(emotionKey, "emotionKey");
        a aVar = this.agents.get(agentId);
        if (aVar == null) {
            return null;
        }
        Iterator<String> it = d(agentId, skinKey).iterator();
        while (it.hasNext()) {
            f fVar = aVar.b().get(it.next());
            if (fVar != null && (cVar = fVar.a().get(emotionKey)) != null) {
                return cVar;
            }
        }
        return null;
    }

    public final String c(String agentId, String skinKey) {
        String fallback;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(skinKey, "skinKey");
        a aVar = this.agents.get(agentId);
        String str = null;
        if (aVar == null) {
            return null;
        }
        a aVar2 = this.agents.get(agentId);
        if (aVar2 != null) {
            Iterator<String> it = d(agentId, skinKey).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar = aVar2.b().get(it.next());
                if (fVar != null && (fallback = fVar.getFallback()) != null) {
                    str = fallback;
                    break;
                }
            }
        }
        return str != null ? str : aVar.getFallback();
    }

    public final List<String> d(String agentId, String skinKey) {
        f fVar;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(skinKey, "skinKey");
        a aVar = this.agents.get(agentId);
        if (aVar == null) {
            return C1173v.m();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (linkedHashSet.add(skinKey) && (fVar = aVar.b().get(skinKey)) != null && (skinKey = fVar.getInheritFrom()) != null) {
        }
        if (!linkedHashSet.contains("default") && aVar.b().containsKey("default")) {
            linkedHashSet.add("default");
        }
        return F.m1(linkedHashSet);
    }

    public final StateSpec e(String agentId, String skinKey, String stateKey, String placeKey) {
        Map<String, StateSpec> mapA;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(skinKey, "skinKey");
        kotlin.jvm.internal.p.i(stateKey, "stateKey");
        if (placeKey != null) {
            a aVar = this.agents.get(agentId);
            Map<String, StateSpec> map = null;
            if (aVar != null) {
                Iterator<String> it = d(agentId, skinKey).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f fVar = aVar.b().get(it.next());
                    if (fVar != null) {
                        C0082e c0082e = fVar.d().get(placeKey);
                        if (c0082e == null || (mapA = c0082e.a()) == null || mapA.isEmpty()) {
                            mapA = null;
                        }
                        if (mapA != null) {
                            map = mapA;
                            break;
                        }
                    }
                }
            }
            if (map != null) {
                StateSpec stateSpec = map.get(stateKey);
                if (stateSpec != null) {
                    return stateSpec;
                }
                StateSpec stateSpec2 = map.get("fallback");
                if (stateSpec2 != null) {
                    return stateSpec2;
                }
            }
        }
        return h(agentId, skinKey, stateKey);
    }

    public final String f(String agentId, String skinKey, String stateKey, String placeKey) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(skinKey, "skinKey");
        kotlin.jvm.internal.p.i(stateKey, "stateKey");
        StateSpec stateSpecE = e(agentId, skinKey, stateKey, placeKey);
        c body = stateSpecE != null ? stateSpecE.getBody() : null;
        c.DrawableSpec drawableSpec = body instanceof c.DrawableSpec ? (c.DrawableSpec) body : null;
        if (drawableSpec != null) {
            return drawableSpec.getName();
        }
        return null;
    }

    public final String g(String agentId, String skinKey, String stateKey, String placeKey) {
        c body;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(skinKey, "skinKey");
        kotlin.jvm.internal.p.i(stateKey, "stateKey");
        StateSpec stateSpecE = e(agentId, skinKey, stateKey, placeKey);
        if (stateSpecE == null || (body = stateSpecE.getBody()) == null) {
            return null;
        }
        return body.getLinesArray();
    }

    public final StateSpec h(String agentId, String skinKey, String stateKey) {
        StateSpec stateSpec;
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(skinKey, "skinKey");
        kotlin.jvm.internal.p.i(stateKey, "stateKey");
        a aVar = this.agents.get(agentId);
        if (aVar == null) {
            return null;
        }
        Iterator<String> it = d(agentId, skinKey).iterator();
        while (it.hasNext()) {
            f fVar = aVar.b().get(it.next());
            if (fVar != null && (stateSpec = fVar.e().get(stateKey)) != null) {
                return stateSpec;
            }
        }
        return null;
    }

    public e(Map<String, a> map) {
        this.agents = map;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001\u0010B[\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"LM4/e$e;", "", "", "LM4/e$c;", "background", com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND, "", "", "LM4/e$g;", "states", "renderer", "entry", "", "sandbox", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Z)V", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "getBackground", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "getForeground", "c", "Ljava/util/Map;", "()Ljava/util/Map;", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "getRenderer", "()Ljava/lang/String;", "e", "getEntry", "f", "Z", "getSandbox", "()Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: M4.e$e, reason: collision with other inner class name */
    public static final class C0082e {

        /* renamed from: h, reason: collision with root package name */
        public static final C0082e f4597h = new C0082e(C1173v.m(), C1173v.m(), null, null, null, false, 60, null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final List<c> background;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final List<c> foreground;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final Map<String, StateSpec> states;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final String renderer;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final String entry;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final boolean sandbox;

        /* JADX WARN: Multi-variable type inference failed */
        public C0082e(List<? extends c> background, List<? extends c> foreground, Map<String, StateSpec> states, String str, String str2, boolean z10) {
            kotlin.jvm.internal.p.i(background, "background");
            kotlin.jvm.internal.p.i(foreground, "foreground");
            kotlin.jvm.internal.p.i(states, "states");
            this.background = background;
            this.foreground = foreground;
            this.states = states;
            this.renderer = str;
            this.entry = str2;
            this.sandbox = z10;
        }

        public final Map<String, StateSpec> a() {
            return this.states;
        }

        public /* synthetic */ C0082e(List list, List list2, Map map, String str, String str2, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this(list, list2, (i10 & 4) != 0 ? kotlin.collections.a.i() : map, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : str2, (i10 & 32) != 0 ? true : z10);
        }
    }
}
