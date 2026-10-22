package Sb;

import Rb.d;
import Yb.AbstractC1128b;
import ac.AbstractC1280a;
import ac.AbstractC1281b;
import ac.AbstractC1285f;
import ac.C1282c;
import ac.InterfaceC1286g;
import ac.InterfaceC1287h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableCell;

/* loaded from: classes5.dex */
public class a extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final Rb.a f5812a;

    /* renamed from: b, reason: collision with root package name */
    public final List<CharSequence> f5813b;

    /* renamed from: c, reason: collision with root package name */
    public final List<TableCell.Alignment> f5814c;

    /* renamed from: d, reason: collision with root package name */
    public final List<String> f5815d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5816e;

    public static class b extends AbstractC1281b {
        @Override // ac.InterfaceC1284e
        public AbstractC1285f a(InterfaceC1287h interfaceC1287h, InterfaceC1286g interfaceC1286g) {
            List listM;
            CharSequence charSequenceB = interfaceC1287h.b();
            CharSequence charSequenceA = interfaceC1286g.a();
            if (charSequenceA != null && charSequenceA.toString().contains("|") && !charSequenceA.toString().contains("\n") && (listM = a.m(charSequenceB.subSequence(interfaceC1287h.getIndex(), charSequenceB.length()))) != null && !listM.isEmpty()) {
                List listN = a.n(charSequenceA);
                if (listM.size() >= listN.size()) {
                    return AbstractC1285f.d(new a(listM, listN)).b(interfaceC1287h.getIndex()).e();
                }
            }
            return AbstractC1285f.c();
        }
    }

    public static TableCell.Alignment k(boolean z10, boolean z11) {
        if (z10 && z11) {
            return TableCell.Alignment.CENTER;
        }
        if (z10) {
            return TableCell.Alignment.LEFT;
        }
        if (z11) {
            return TableCell.Alignment.RIGHT;
        }
        return null;
    }

    public static List<TableCell.Alignment> m(CharSequence charSequence) {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        boolean z11 = false;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt == '\t' || cCharAt == ' ') {
                i10++;
            } else {
                boolean z12 = true;
                if (cCharAt == '-' || cCharAt == ':') {
                    if (i11 == 0 && !arrayList.isEmpty()) {
                        return null;
                    }
                    if (cCharAt == ':') {
                        i10++;
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    boolean z13 = false;
                    while (i10 < charSequence.length() && charSequence.charAt(i10) == '-') {
                        i10++;
                        z13 = true;
                    }
                    if (!z13) {
                        return null;
                    }
                    if (i10 >= charSequence.length() || charSequence.charAt(i10) != ':') {
                        z12 = false;
                    } else {
                        i10++;
                    }
                    arrayList.add(k(z10, z12));
                    i11 = 0;
                } else {
                    if (cCharAt != '|') {
                        return null;
                    }
                    i10++;
                    i11++;
                    if (i11 > 1) {
                        return null;
                    }
                    z11 = true;
                }
            }
        }
        if (z11) {
            return arrayList;
        }
        return null;
    }

    public static List<String> n(CharSequence charSequence) {
        String strTrim = charSequence.toString().trim();
        if (strTrim.startsWith("|")) {
            strTrim = strTrim.substring(1);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        while (i10 < strTrim.length()) {
            char cCharAt = strTrim.charAt(i10);
            if (cCharAt == '\\') {
                int i11 = i10 + 1;
                if (i11 >= strTrim.length() || strTrim.charAt(i11) != '|') {
                    sb2.append('\\');
                } else {
                    sb2.append('|');
                    i10 = i11;
                }
            } else if (cCharAt != '|') {
                sb2.append(cCharAt);
            } else {
                arrayList.add(sb2.toString());
                sb2.setLength(0);
            }
            i10++;
        }
        if (sb2.length() > 0) {
            arrayList.add(sb2.toString());
        }
        return arrayList;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void b(Zb.a aVar) {
        int size = this.f5815d.size();
        Rb.c cVar = new Rb.c();
        this.f5812a.b(cVar);
        d dVar = new d();
        cVar.b(dVar);
        for (int i10 = 0; i10 < size; i10++) {
            TableCell tableCellL = l(this.f5815d.get(i10), i10, aVar);
            tableCellL.p(true);
            dVar.b(tableCellL);
        }
        Iterator<CharSequence> it = this.f5813b.iterator();
        Rb.b bVar = null;
        while (it.hasNext()) {
            List<String> listN = n(it.next());
            d dVar2 = new d();
            int i11 = 0;
            while (i11 < size) {
                dVar2.b(l(i11 < listN.size() ? listN.get(i11) : "", i11, aVar));
                i11++;
            }
            if (bVar == null) {
                bVar = new Rb.b();
                this.f5812a.b(bVar);
            }
            bVar.b(dVar2);
        }
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public boolean c() {
        return true;
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        return interfaceC1287h.b().toString().contains("|") ? C1282c.b(interfaceC1287h.getIndex()) : C1282c.d();
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f5812a;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public void f(CharSequence charSequence) {
        if (this.f5816e) {
            this.f5816e = false;
        } else {
            this.f5813b.add(charSequence);
        }
    }

    public final TableCell l(String str, int i10, Zb.a aVar) {
        TableCell tableCell = new TableCell();
        if (i10 < this.f5814c.size()) {
            tableCell.o(this.f5814c.get(i10));
        }
        aVar.n(str.trim(), tableCell);
        return tableCell;
    }

    public a(List<TableCell.Alignment> list, List<String> list2) {
        this.f5812a = new Rb.a();
        this.f5813b = new ArrayList();
        this.f5816e = true;
        this.f5814c = list;
        this.f5815d = list2;
    }
}
