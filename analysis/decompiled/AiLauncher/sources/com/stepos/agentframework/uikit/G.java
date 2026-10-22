package com.stepos.agentframework.uikit;

import C8.f;
import C8.h;
import com.autonavi.aps.amapapi.config.Const;
import com.caverock.androidsvg.SVGParser;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.Regex;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 '2\u00020\u0001:\u0003()*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001aj\b\u0012\u0004\u0012\u00020\u0007`\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0011\u0010&\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/stepos/agentframework/uikit/G;", "", "<init>", "()V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "output", "", "fragment", "Lcom/stepos/agentframework/uikit/G$b;", Const.INTENT_KEY_UMID, "(Ljava/lang/StringBuilder;Ljava/lang/String;)Lcom/stepos/agentframework/uikit/G$b;", "Lkotlin/Function0;", "LY8/t;", "checkCancelled", "", "Lcom/stepos/agentframework/uikit/G$c;", "e", "(Lp9/a;)Ljava/util/List;", "LC8/i;", "parser", "LC8/i;", "", "openInline", "Ljava/util/List;", "openBlocks", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "names", "Ljava/util/LinkedHashSet;", "", UxipConstants.f30680s, "fragmentCount", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/String;", "tagNames", "Companion", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class G {
    private int fragmentCount;
    private final LinkedHashSet<String> names;
    private final List<String> openBlocks;
    private final List<String> openInline;
    private final C8.i parser;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex tagPattern = new Regex("^<(/?)([A-Za-z][A-Za-z0-9-]*)");
    private static final Set<String> voidTags = Z8.Y.j("br", "wbr");
    private static final Set<String> inlineTags = Z8.Y.j(Const.INTENT_KEY_APIKEY, "abbr", "acronym", Const.INTENT_KEY_PKGNAME, "bdo", "big", "br", "cite", "code", "dfn", "em", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "kbd", "q", "samp", "small", "span", "strong", "sub", "sup", "time", "tt", "var");
    private static final Set<String> unsupported = Z8.Y.j(Const.JSON_KEY_ADDRESS, "article", "aside", "blockquote", "canvas", "dd", "div", "dl", "dt", "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", "header", "hgroup", "hr", "li", "main", "nav", "noscript", Const.SP_KEY_ONCE_LOCATION, "output", "p", "pre", "section", "table", "thead", "tbody", "tfoot", "tr", "th", "td", "ul", "video", "audio", "img", "iframe", "object", "embed", "source", "track", "script", "style", "button", "input", M5.c.ACTION_SELECT, "textarea", "label", C3081a.FOCUS_MAP_NAME, "area", "base", "col", "keygen", "link", "meta", "param");

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/uikit/G$a;", "", "<init>", "()V", "", "fragment", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/text/Regex;", "tagPattern", "Lkotlin/text/Regex;", "", "voidTags", "Ljava/util/Set;", "inlineTags", "unsupported", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.uikit.G$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String a(String fragment) {
            List<String> listC;
            String str;
            kotlin.jvm.internal.p.i(fragment, "fragment");
            String strR1 = null;
            La.m mVarD = Regex.d(G.tagPattern, fragment, 0, 2, null);
            if (mVarD != null && (listC = mVarD.c()) != null && (str = listC.get(2)) != null) {
                Locale ROOT = Locale.ROOT;
                kotlin.jvm.internal.p.h(ROOT, "ROOT");
                String lowerCase = str.toLowerCase(ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                if (lowerCase != null) {
                    strR1 = La.K.R1(lowerCase, 32);
                }
            }
            return strR1 == null ? "" : strR1;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/uikit/G$b;", "", "", "tag", "", "nestingLimit", "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Z", Const.INTENT_KEY_APIKEY, "()Z", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.uikit.G$b, reason: from toString */
    public static final /* data */ class Rejection {
        private final boolean nestingLimit;
        private final String tag;

        public Rejection(String tag, boolean z10) {
            kotlin.jvm.internal.p.i(tag, "tag");
            this.tag = tag;
            this.nestingLimit = z10;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getNestingLimit() {
            return this.nestingLimit;
        }

        /* renamed from: b, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Rejection)) {
                return false;
            }
            Rejection rejection = (Rejection) other;
            return kotlin.jvm.internal.p.d(this.tag, rejection.tag) && this.nestingLimit == rejection.nestingLimit;
        }

        public int hashCode() {
            return (this.tag.hashCode() * 31) + Boolean.hashCode(this.nestingLimit);
        }

        public String toString() {
            return "Rejection(tag=" + this.tag + ", nestingLimit=" + this.nestingLimit + ")";
        }

        public /* synthetic */ Rejection(String str, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, (i10 & 2) != 0 ? false : z10);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/uikit/G$c;", "", "", "name", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, SVGParser.XML_STYLESHEET_ATTR_HREF, "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "I", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.uikit.G$c, reason: from toString */
    public static final /* data */ class Tag {
        private final int end;
        private final String href;
        private final String name;
        private final int start;

        public Tag(String name, int i10, int i11, String href) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(href, "href");
            this.name = name;
            this.start = i10;
            this.end = i11;
            this.href = href;
        }

        /* renamed from: a, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: b, reason: from getter */
        public final String getHref() {
            return this.href;
        }

        /* renamed from: c, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: d, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tag)) {
                return false;
            }
            Tag tag = (Tag) other;
            return kotlin.jvm.internal.p.d(this.name, tag.name) && this.start == tag.start && this.end == tag.end && kotlin.jvm.internal.p.d(this.href, tag.href);
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end)) * 31) + this.href.hashCode();
        }

        public String toString() {
            return "Tag(name=" + this.name + ", start=" + this.start + ", end=" + this.end + ", href=" + this.href + ")";
        }
    }

    public G() {
        C8.i iVarG = C8.i.g();
        kotlin.jvm.internal.p.h(iVarG, "create(...)");
        this.parser = iVarG;
        this.openInline = new ArrayList();
        this.openBlocks = new ArrayList();
        this.names = new LinkedHashSet<>();
    }

    public static final void f(InterfaceC5063a<Y8.t> interfaceC5063a, ArrayList<Tag> arrayList, C8.f fVar) {
        interfaceC5063a.invoke();
        if (fVar.isClosed()) {
            if (fVar.c()) {
                List<f.a> listB = fVar.a().b();
                kotlin.jvm.internal.p.h(listB, "children(...)");
                Iterator<T> it = listB.iterator();
                while (it.hasNext()) {
                    f(interfaceC5063a, arrayList, (C8.f) it.next());
                }
            }
            if (fVar.isEmpty()) {
                return;
            }
            String strName = fVar.name();
            kotlin.jvm.internal.p.h(strName, "name(...)");
            int iStart = fVar.start();
            int iEnd = fVar.end();
            String str = fVar.d().get(SVGParser.XML_STYLESHEET_ATTR_HREF);
            if (str == null) {
                str = "";
            }
            arrayList.add(new Tag(strName, iStart, iEnd, str));
        }
    }

    public static final void g(InterfaceC5063a interfaceC5063a, ArrayList arrayList, List it) {
        kotlin.jvm.internal.p.i(it, "it");
        Iterator it2 = it.iterator();
        while (it2.hasNext()) {
            f(interfaceC5063a, arrayList, (C8.f) it2.next());
        }
    }

    public static final void h(InterfaceC5063a interfaceC5063a, ArrayList arrayList, List it) {
        kotlin.jvm.internal.p.i(it, "it");
        Iterator it2 = it.iterator();
        while (it2.hasNext()) {
            f(interfaceC5063a, arrayList, (C8.f) it2.next());
        }
    }

    public final Rejection d(StringBuilder output, String fragment) throws IOException {
        int iNextIndex;
        kotlin.jvm.internal.p.i(output, "output");
        kotlin.jvm.internal.p.i(fragment, "fragment");
        boolean z10 = false;
        int i10 = 2;
        kotlin.jvm.internal.i iVar = null;
        La.m mVarD = Regex.d(tagPattern, fragment, 0, 2, null);
        if (mVarD != null) {
            String str = mVarD.c().get(2);
            Locale ROOT = Locale.ROOT;
            kotlin.jvm.internal.p.h(ROOT, "ROOT");
            String lowerCase = str.toLowerCase(ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            if (unsupported.contains(lowerCase)) {
                return new Rejection(INSTANCE.a(fragment), z10, i10, iVar);
            }
            if (this.names.size() < 8) {
                this.names.add(La.K.R1(lowerCase, 32));
            }
            boolean zContains = inlineTags.contains(lowerCase);
            List<String> list = !zContains ? this.openBlocks : this.openInline;
            if (kotlin.jvm.internal.p.d(mVarD.c().get(1), "/")) {
                ListIterator<String> listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        iNextIndex = -1;
                        break;
                    }
                    if (kotlin.jvm.internal.p.d(listIterator.previous(), lowerCase)) {
                        iNextIndex = listIterator.nextIndex();
                        break;
                    }
                }
                if (iNextIndex < 0) {
                    this.fragmentCount++;
                    return null;
                }
                if (zContains) {
                    list.remove(iNextIndex);
                } else {
                    list.subList(iNextIndex, list.size()).clear();
                }
            } else if (!voidTags.contains(lowerCase) && !La.D.K(fragment, "/>", false, 2, null)) {
                if (this.openBlocks.size() + this.openInline.size() >= 64) {
                    return new Rejection(La.K.R1(lowerCase, 32), true);
                }
                list.add(lowerCase);
            }
        }
        this.fragmentCount++;
        this.parser.c(output, fragment);
        return null;
    }

    public final List<Tag> e(final InterfaceC5063a<Y8.t> checkCancelled) {
        kotlin.jvm.internal.p.i(checkCancelled, "checkCancelled");
        final ArrayList arrayList = new ArrayList();
        this.parser.b(-1, new h.a() { // from class: com.stepos.agentframework.uikit.E
            @Override // C8.h.a
            public final void a(List list) {
                G.g(checkCancelled, arrayList, list);
            }
        });
        this.parser.a(-1, new h.a() { // from class: com.stepos.agentframework.uikit.F
            @Override // C8.h.a
            public final void a(List list) {
                G.h(checkCancelled, arrayList, list);
            }
        });
        this.parser.d();
        return arrayList;
    }

    /* renamed from: i, reason: from getter */
    public final int getFragmentCount() {
        return this.fragmentCount;
    }

    public final String j() {
        return Z8.F.A0(this.names, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null);
    }
}
