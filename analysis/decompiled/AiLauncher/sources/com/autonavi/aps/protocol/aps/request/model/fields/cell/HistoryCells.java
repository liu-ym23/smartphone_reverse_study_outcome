package com.autonavi.aps.protocol.aps.request.model.fields.cell;

import com.autonavi.aps.protocol.aps.common.e.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class HistoryCells extends ArrayList<f> {

    public static class a implements f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f18966a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f18967b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f18968c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f18969d = 0;

        /* renamed from: e, reason: collision with root package name */
        private short f18970e = 0;

        public void a(boolean z10) {
            this.f18966a = z10;
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.HistoryCells.f
        public byte b() {
            return (byte) 2;
        }

        public int c() {
            return this.f18967b;
        }

        public int d() {
            return this.f18968c;
        }

        public int e() {
            return this.f18969d;
        }

        public int f() {
            return g.a(this.f18970e);
        }

        public String toString() {
            return "HistoryCellCdma{isMain=" + this.f18966a + ", sid=" + this.f18967b + ", nid=" + this.f18968c + ", bid=" + this.f18969d + ", cellAge=" + ((int) this.f18970e) + '}';
        }

        public boolean a() {
            return this.f18966a;
        }

        public void b(int i10) {
            this.f18968c = i10;
        }

        public void c(int i10) {
            this.f18969d = i10;
        }

        public void d(int i10) {
            Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18508a;
            if (i10 > num.intValue()) {
                i10 = num.intValue();
            }
            Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18509b;
            if (i10 < num2.intValue()) {
                i10 = num2.intValue();
            }
            this.f18970e = (short) i10;
        }

        public void a(int i10) {
            this.f18967b = i10;
        }
    }

    public static class b implements f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f18971a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f18972b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f18973c = 0;

        /* renamed from: d, reason: collision with root package name */
        private short f18974d = 0;

        public void a(boolean z10) {
            this.f18971a = z10;
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.HistoryCells.f
        public byte b() {
            return (byte) 1;
        }

        public int c() {
            return this.f18972b;
        }

        public int d() {
            return this.f18973c;
        }

        public int e() {
            return g.a(this.f18974d);
        }

        public String toString() {
            return "HistoryCellGsm{isMain=" + this.f18971a + ", lac=" + this.f18972b + ", cellId=" + this.f18973c + ", cellAge=" + ((int) this.f18974d) + '}';
        }

        public boolean a() {
            return this.f18971a;
        }

        public void b(int i10) {
            this.f18973c = i10;
        }

        public void c(int i10) {
            Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18508a;
            if (i10 > num.intValue()) {
                i10 = num.intValue();
            }
            Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18509b;
            if (i10 < num2.intValue()) {
                i10 = num2.intValue();
            }
            this.f18974d = (short) i10;
        }

        public void a(int i10) {
            this.f18972b = i10;
        }
    }

    public static class c extends b {
        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.HistoryCells.b, com.autonavi.aps.protocol.aps.request.model.fields.cell.HistoryCells.f
        public byte b() {
            return (byte) 3;
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.HistoryCells.b
        public String toString() {
            return "HistoryCellLte{}" + super.toString();
        }
    }

    public static class d implements f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f18975a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f18976b = 0;

        /* renamed from: c, reason: collision with root package name */
        private long f18977c = 0;

        /* renamed from: d, reason: collision with root package name */
        private short f18978d = 0;

        public void a(boolean z10) {
            this.f18975a = z10;
        }

        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.HistoryCells.f
        public byte b() {
            return (byte) 5;
        }

        public int c() {
            return this.f18976b;
        }

        public long d() {
            return this.f18977c;
        }

        public int e() {
            return g.a(this.f18978d);
        }

        public boolean a() {
            return this.f18975a;
        }

        public void b(int i10) {
            Integer num = com.autonavi.aps.protocol.aps.common.constant.a.f18508a;
            if (i10 > num.intValue()) {
                i10 = num.intValue();
            }
            Integer num2 = com.autonavi.aps.protocol.aps.common.constant.a.f18509b;
            if (i10 < num2.intValue()) {
                i10 = num2.intValue();
            }
            this.f18978d = (short) i10;
        }

        public void a(int i10) {
            this.f18976b = i10;
        }

        public void a(long j10) {
            this.f18977c = j10;
        }
    }

    public static class e extends b {
        @Override // com.autonavi.aps.protocol.aps.request.model.fields.cell.HistoryCells.b, com.autonavi.aps.protocol.aps.request.model.fields.cell.HistoryCells.f
        public byte b() {
            return (byte) 4;
        }
    }

    public interface f {
        byte b();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "HistoryCells{}" + super.toString();
    }
}
