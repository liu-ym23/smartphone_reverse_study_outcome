package com.autonavi.aps.protocol.aps.request.model.fields.cell;

import com.autonavi.aps.protocol.aps.common.e.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NewApiCells extends ArrayList<a> {

    public interface a {
        boolean a();

        byte i();
    }

    public static class b extends com.autonavi.aps.protocol.aps.request.model.fields.cell.a implements a {

        /* renamed from: i, reason: collision with root package name */
        private boolean f18979i = false;

        public void a(boolean z10) {
            this.f18979i = z10;
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.a, com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells.a
        public byte i() {
            return super.i();
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells.a
        public boolean a() {
            return this.f18979i;
        }
    }

    public static class c extends com.autonavi.aps.protocol.aps.request.model.fields.cell.b implements a {

        /* renamed from: g, reason: collision with root package name */
        private boolean f18980g = false;

        /* renamed from: h, reason: collision with root package name */
        private short f18981h = Short.MAX_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private int f18982i = Integer.MAX_VALUE;

        /* renamed from: j, reason: collision with root package name */
        private int f18983j = Integer.MAX_VALUE;

        public void a(boolean z10) {
            this.f18980g = z10;
        }

        public void f(int i10) {
            Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18508a;
            if (i10 > num.intValue()) {
                i10 = num.intValue();
            }
            Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18509b;
            if (i10 < num2.intValue()) {
                i10 = num2.intValue();
            }
            this.f18981h = (short) i10;
        }

        public int g() {
            return g.a(this.f18981h);
        }

        public int h() {
            return this.f18982i;
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.b, com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells.a
        public byte i() {
            return super.i();
        }

        public int j() {
            return this.f18983j;
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells.a
        public boolean a() {
            return this.f18980g;
        }

        public void g(int i10) {
            this.f18982i = i10;
        }

        public void h(int i10) {
            this.f18983j = i10;
        }
    }

    public static class d extends com.autonavi.aps.protocol.aps.request.model.fields.cell.c implements a {

        /* renamed from: j, reason: collision with root package name */
        private boolean f18984j = false;

        public void a(boolean z10) {
            this.f18984j = z10;
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.c, com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells.a
        public byte i() {
            return super.i();
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells.a
        public boolean a() {
            return this.f18984j;
        }
    }

    public static class e extends com.autonavi.aps.protocol.aps.request.model.fields.cell.d implements a {

        /* renamed from: j, reason: collision with root package name */
        private boolean f18985j = false;

        public void a(boolean z10) {
            this.f18985j = z10;
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.d, com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells.a
        public byte i() {
            return super.i();
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells.a
        public boolean a() {
            return this.f18985j;
        }
    }

    public static class f extends com.autonavi.aps.protocol.aps.request.model.fields.cell.e implements a {

        /* renamed from: j, reason: collision with root package name */
        private boolean f18986j = false;

        public void a(boolean z10) {
            this.f18986j = z10;
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.e, com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells.a
        public byte i() {
            return super.i();
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.e
        public String toString() {
            return "NewApiCellWcdma{" + super.toString() + "isMain=" + this.f18986j + '}';
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.NewApiCells.a
        public boolean a() {
            return this.f18986j;
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "NewApiCells{" + super.toString() + "}";
    }
}
