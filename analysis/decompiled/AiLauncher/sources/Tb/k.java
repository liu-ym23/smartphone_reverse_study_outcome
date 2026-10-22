package Tb;

import Yb.AbstractC1128b;
import Yb.w;
import ac.AbstractC1280a;
import ac.AbstractC1281b;
import ac.AbstractC1285f;
import ac.C1282c;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class k extends AbstractC1280a {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern[][] f5970e = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};

    /* renamed from: a, reason: collision with root package name */
    public final Yb.m f5971a;

    /* renamed from: b, reason: collision with root package name */
    public final Pattern f5972b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5973c;

    /* renamed from: d, reason: collision with root package name */
    public Tb.a f5974d;

    public static class b extends AbstractC1281b {
        @Override // ac.InterfaceC1284e
        public AbstractC1285f a(InterfaceC1287h interfaceC1287h, InterfaceC1286g interfaceC1286g) {
            int iE = interfaceC1287h.e();
            CharSequence charSequenceB = interfaceC1287h.b();
            if (interfaceC1287h.d() < 4 && charSequenceB.charAt(iE) == '<') {
                for (int i10 = 1; i10 <= 7; i10++) {
                    if (i10 != 7 || !(interfaceC1286g.b().e() instanceof w)) {
                        Pattern pattern = k.f5970e[i10][0];
                        Pattern pattern2 = k.f5970e[i10][1];
                        if (pattern.matcher(charSequenceB.subSequence(iE, charSequenceB.length())).find()) {
                            return AbstractC1285f.d(new k(pattern2)).b(interfaceC1287h.getIndex());
                        }
                    }
                }
            }
            return AbstractC1285f.c();
        }
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        return this.f5973c ? C1282c.d() : (interfaceC1287h.a() && this.f5972b == null) ? C1282c.d() : C1282c.b(interfaceC1287h.getIndex());
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f5971a;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void f(CharSequence charSequence) {
        this.f5974d.a(charSequence);
        Pattern pattern = this.f5972b;
        if (pattern == null || !pattern.matcher(charSequence).find()) {
            return;
        }
        this.f5973c = true;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void g() {
        this.f5971a.o(this.f5974d.b());
        this.f5974d = null;
    }

    public k(Pattern pattern) {
        this.f5971a = new Yb.m();
        this.f5973c = false;
        this.f5974d = new Tb.a();
        this.f5972b = pattern;
    }
}
