package La;

import La.m;
import La.n;
import Z8.AbstractC1154b;
import Z8.AbstractC1156d;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import i9.C4179b;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import v9.C5680i;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u001eR\u0014\u0010#\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"LLa/n;", "LLa/m;", "Ljava/util/regex/Matcher;", "matcher", "", "input", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "next", "()LLa/m;", Const.INTENT_KEY_APIKEY, "Ljava/util/regex/Matcher;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/CharSequence;", "LLa/k;", "c", "LLa/k;", Const.INTENT_KEY_UMID, "()LLa/k;", "groups", "", "", "Ljava/util/List;", "groupValues_", "Lv9/i;", "()Lv9/i;", "range", "getValue", "()Ljava/lang/String;", UxipConstants.f30680s, "()Ljava/util/List;", "groupValues", "Ljava/util/regex/MatchResult;", "f", "()Ljava/util/regex/MatchResult;", "matchResult", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class n implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Matcher matcher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CharSequence input;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0961k groups;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public List<String> groupValues_;

    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"La/n$a", "LZ8/d;", "", "", "index", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Ljava/lang/String;", "c", "()I", ContentDisposition.Parameters.Size, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1156d<String> {
        public a() {
        }

        @Override // Z8.AbstractC1154b
        /* renamed from: c */
        public int getSize() {
            return n.this.f().groupCount() + 1;
        }

        @Override // Z8.AbstractC1154b, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return f((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(String str) {
            return super.contains(str);
        }

        @Override // Z8.AbstractC1156d, java.util.List
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public String get(int index) {
            String strGroup = n.this.f().group(index);
            return strGroup == null ? "" : strGroup;
        }

        @Override // Z8.AbstractC1156d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return j((String) obj);
            }
            return -1;
        }

        public /* bridge */ int j(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int k(String str) {
            return super.lastIndexOf(str);
        }

        @Override // Z8.AbstractC1156d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return k((String) obj);
            }
            return -1;
        }
    }

    public n(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.p.i(matcher, "matcher");
        kotlin.jvm.internal.p.i(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new b();
    }

    @Override // La.m
    public C5680i a() {
        return q.h(f());
    }

    @Override // La.m
    public /* bridge */ m.b b() {
        return m.a.a(this);
    }

    @Override // La.m
    public List<String> c() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new a();
        }
        List<String> list = this.groupValues_;
        kotlin.jvm.internal.p.f(list);
        return list;
    }

    @Override // La.m
    /* renamed from: d, reason: from getter */
    public InterfaceC0961k getGroups() {
        return this.groups;
    }

    public final MatchResult f() {
        return this.matcher;
    }

    @Override // La.m
    public String getValue() {
        String strGroup = f().group();
        kotlin.jvm.internal.p.h(strGroup, "group(...)");
        return strGroup;
    }

    @Override // La.m
    public m next() {
        int iEnd = f().end() + (f().end() == f().start() ? 1 : 0);
        if (iEnd > this.input.length()) {
            return null;
        }
        Matcher matcher = this.matcher.pattern().matcher(this.input);
        kotlin.jvm.internal.p.h(matcher, "matcher(...)");
        return q.f(matcher, iEnd, this.input);
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0002¢\u0006\u0004\b\f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"La/n$b", "LLa/l;", "LZ8/b;", "LLa/j;", "", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "index", "get", "(I)LLa/j;", "", "name", "(Ljava/lang/String;)LLa/j;", "c", "()I", ContentDisposition.Parameters.Size, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AbstractC1154b<MatchGroup> implements InterfaceC0962l {
        public b() {
        }

        public static final MatchGroup j(b bVar, int i10) {
            return bVar.get(i10);
        }

        @Override // Z8.AbstractC1154b
        /* renamed from: c */
        public int getSize() {
            return n.this.f().groupCount() + 1;
        }

        @Override // Z8.AbstractC1154b, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof MatchGroup) {
                return i((MatchGroup) obj);
            }
            return false;
        }

        @Override // La.InterfaceC0961k
        public MatchGroup get(int index) {
            C5680i c5680iI = q.i(n.this.f(), index);
            if (c5680iI.l().intValue() < 0) {
                return null;
            }
            String strGroup = n.this.f().group(index);
            kotlin.jvm.internal.p.h(strGroup, "group(...)");
            return new MatchGroup(strGroup, c5680iI);
        }

        public /* bridge */ boolean i(MatchGroup matchGroup) {
            return super.contains(matchGroup);
        }

        @Override // Z8.AbstractC1154b, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<MatchGroup> iterator() {
            return SequencesKt___SequencesKt.R(Z8.F.d0(C1173v.n(this)), new InterfaceC5074l() { // from class: La.o
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return n.b.j(this.f4400a, ((Integer) obj).intValue());
                }
            }).iterator();
        }

        @Override // La.InterfaceC0962l
        public MatchGroup get(String name) {
            kotlin.jvm.internal.p.i(name, "name");
            return C4179b.f33080a.c(n.this.f(), name);
        }
    }
}
