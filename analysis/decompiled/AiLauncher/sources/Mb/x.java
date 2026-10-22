package Mb;

import Z8.AbstractC1156d;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.io.IOException;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u001aB!\b\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0017¨\u0006\u001b"}, d2 = {"LMb/x;", "LZ8/d;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "byteStrings", "", "trie", "<init>", "([Lokio/ByteString;[I)V", "", "index", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Lokio/ByteString;", Const.INTENT_KEY_PKGNAME, "[Lokio/ByteString;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()[Lokio/ByteString;", "c", "[I", "k", "()[I", "()I", ContentDisposition.Parameters.Size, Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class x extends AbstractC1156d<ByteString> implements RandomAccess {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ByteString[] byteStrings;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int[] trie;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ[\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u00020\n*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"LMb/x$a;", "", "<init>", "()V", "", "Lokio/ByteString;", "byteStrings", "LMb/x;", Const.INTENT_KEY_UMID, "([Lokio/ByteString;)LMb/x;", "", "nodeOffset", "LMb/d;", "node", "", "byteStringOffset", "", "fromIndex", "toIndex", "indexes", "LY8/t;", Const.INTENT_KEY_APIKEY, "(JLMb/d;ILjava/util/List;IILjava/util/List;)V", "c", "(LMb/d;)J", "intCount", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Mb.x$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, long j10, C0966d c0966d, int i10, List list, int i11, int i12, List list2, int i13, Object obj) throws IOException {
            if ((i13 & 1) != 0) {
                j10 = 0;
            }
            companion.a(j10, c0966d, (i13 & 4) != 0 ? 0 : i10, list, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? list.size() : i12, list2);
        }

        public final void a(long nodeOffset, C0966d node, int byteStringOffset, List<? extends ByteString> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) throws IOException {
            int i10;
            int i11;
            int i12;
            long j10;
            int i13 = byteStringOffset;
            if (fromIndex >= toIndex) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i14 = fromIndex; i14 < toIndex; i14++) {
                if (byteStrings.get(i14).K() < i13) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = byteStrings.get(fromIndex);
            ByteString byteString2 = byteStrings.get(toIndex - 1);
            if (i13 == byteString.K()) {
                int iIntValue = indexes.get(fromIndex).intValue();
                int i15 = fromIndex + 1;
                ByteString byteString3 = byteStrings.get(i15);
                i10 = i15;
                i11 = iIntValue;
                byteString = byteString3;
            } else {
                i10 = fromIndex;
                i11 = -1;
            }
            if (byteString.l(i13) == byteString2.l(i13)) {
                int iMin = Math.min(byteString.K(), byteString2.K());
                int i16 = 0;
                for (int i17 = i13; i17 < iMin && byteString.l(i17) == byteString2.l(i17); i17++) {
                    i16++;
                }
                long jC = nodeOffset + c(node) + 2 + i16 + 1;
                node.writeInt(-i16);
                node.writeInt(i11);
                int i18 = i13 + i16;
                while (i13 < i18) {
                    node.writeInt(byteString.l(i13) & 255);
                    i13++;
                }
                if (i10 + 1 == toIndex) {
                    if (i18 != byteStrings.get(i10).K()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    node.writeInt(indexes.get(i10).intValue());
                    return;
                } else {
                    C0966d c0966d = new C0966d();
                    node.writeInt(((int) (c(c0966d) + jC)) * (-1));
                    a(jC, c0966d, i18, byteStrings, i10, toIndex, indexes);
                    node.V0(c0966d);
                    return;
                }
            }
            int i19 = 1;
            for (int i20 = i10 + 1; i20 < toIndex; i20++) {
                if (byteStrings.get(i20 - 1).l(i13) != byteStrings.get(i20).l(i13)) {
                    i19++;
                }
            }
            long jC2 = nodeOffset + c(node) + 2 + (i19 * 2);
            node.writeInt(i19);
            node.writeInt(i11);
            for (int i21 = i10; i21 < toIndex; i21++) {
                byte bL = byteStrings.get(i21).l(i13);
                if (i21 == i10 || bL != byteStrings.get(i21 - 1).l(i13)) {
                    node.writeInt(bL & 255);
                }
            }
            C0966d c0966d2 = new C0966d();
            while (i10 < toIndex) {
                byte bL2 = byteStrings.get(i10).l(i13);
                int i22 = i10 + 1;
                int i23 = i22;
                while (true) {
                    if (i23 >= toIndex) {
                        i12 = toIndex;
                        break;
                    } else {
                        if (bL2 != byteStrings.get(i23).l(i13)) {
                            i12 = i23;
                            break;
                        }
                        i23++;
                    }
                }
                if (i22 == i12 && i13 + 1 == byteStrings.get(i10).K()) {
                    node.writeInt(indexes.get(i10).intValue());
                    j10 = jC2;
                } else {
                    node.writeInt(((int) (c(c0966d2) + jC2)) * (-1));
                    j10 = jC2;
                    a(j10, c0966d2, i13 + 1, byteStrings, i10, i12, indexes);
                }
                jC2 = j10;
                i10 = i12;
            }
            node.V0(c0966d2);
        }

        public final long c(C0966d c0966d) {
            return c0966d.getSize() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00cb, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final Mb.x d(okio.ByteString... r17) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 268
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: Mb.x.Companion.d(okio.ByteString[]):Mb.x");
        }

        public Companion() {
        }
    }

    public /* synthetic */ x(ByteString[] byteStringArr, int[] iArr, kotlin.jvm.internal.i iVar) {
        this(byteStringArr, iArr);
    }

    public static final x n(ByteString... byteStringArr) {
        return INSTANCE.d(byteStringArr);
    }

    @Override // Z8.AbstractC1154b
    /* renamed from: c */
    public int getSize() {
        return this.byteStrings.length;
    }

    @Override // Z8.AbstractC1154b, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return f((ByteString) obj);
        }
        return false;
    }

    public /* bridge */ boolean f(ByteString byteString) {
        return super.contains(byteString);
    }

    @Override // Z8.AbstractC1156d, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return l((ByteString) obj);
        }
        return -1;
    }

    /* renamed from: j, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    /* renamed from: k, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    public /* bridge */ int l(ByteString byteString) {
        return super.indexOf(byteString);
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return m((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int m(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }

    public x(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }
}
