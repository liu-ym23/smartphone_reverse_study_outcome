package io.noties.markwon.ext.tables;

import Rb.d;
import Yb.AbstractC1127a;
import Yb.g;
import android.text.Spanned;
import java.util.ArrayList;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableCell;
import u8.e;

/* loaded from: classes4.dex */
public class Table {

    /* renamed from: a, reason: collision with root package name */
    public final List<c> f34210a;

    public enum Alignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Alignment f34211a;

        /* renamed from: b, reason: collision with root package name */
        public final Spanned f34212b;

        public a(Alignment alignment, Spanned spanned) {
            this.f34211a = alignment;
            this.f34212b = spanned;
        }

        public Alignment a() {
            return this.f34211a;
        }

        public Spanned b() {
            return this.f34212b;
        }

        public String toString() {
            return "Column{alignment=" + this.f34211a + ", content=" + ((Object) this.f34212b) + '}';
        }
    }

    public static class b extends AbstractC1127a {

        /* renamed from: a, reason: collision with root package name */
        public final e f34213a;

        /* renamed from: b, reason: collision with root package name */
        public List<c> f34214b;

        /* renamed from: c, reason: collision with root package name */
        public List<a> f34215c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f34216d;

        public b(e eVar) {
            this.f34213a = eVar;
        }

        public static Alignment K(TableCell.Alignment alignment) {
            return TableCell.Alignment.RIGHT == alignment ? Alignment.RIGHT : TableCell.Alignment.CENTER == alignment ? Alignment.CENTER : Alignment.LEFT;
        }

        @Override // Yb.AbstractC1127a, Yb.B
        public void E(g gVar) {
            if (gVar instanceof TableCell) {
                TableCell tableCell = (TableCell) gVar;
                if (this.f34215c == null) {
                    this.f34215c = new ArrayList(2);
                }
                this.f34215c.add(new a(K(tableCell.m()), this.f34213a.e(tableCell)));
                this.f34216d = tableCell.n();
                return;
            }
            if (!(gVar instanceof Rb.c) && !(gVar instanceof d)) {
                g(gVar);
                return;
            }
            g(gVar);
            List<a> list = this.f34215c;
            if (list != null && list.size() > 0) {
                if (this.f34214b == null) {
                    this.f34214b = new ArrayList(2);
                }
                this.f34214b.add(new c(this.f34216d, this.f34215c));
            }
            this.f34215c = null;
            this.f34216d = false;
        }

        public List<c> L() {
            return this.f34214b;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f34217a;

        /* renamed from: b, reason: collision with root package name */
        public final List<a> f34218b;

        public c(boolean z10, List<a> list) {
            this.f34217a = z10;
            this.f34218b = list;
        }

        public List<a> a() {
            return this.f34218b;
        }

        public boolean b() {
            return this.f34217a;
        }

        public String toString() {
            return "Row{isHeader=" + this.f34217a + ", columns=" + this.f34218b + '}';
        }
    }

    public Table(List<c> list) {
        this.f34210a = list;
    }

    public static Table a(e eVar, Rb.a aVar) {
        b bVar = new b(eVar);
        aVar.a(bVar);
        List<c> listL = bVar.L();
        if (listL == null) {
            return null;
        }
        return new Table(listL);
    }

    public List<c> b() {
        return this.f34210a;
    }

    public String toString() {
        return "Table{rows=" + this.f34210a + '}';
    }
}
