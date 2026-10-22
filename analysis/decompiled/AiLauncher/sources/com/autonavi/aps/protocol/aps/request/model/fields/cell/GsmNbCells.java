package com.autonavi.aps.protocol.aps.request.model.fields.cell;

import com.autonavi.aps.protocol.aps.common.e.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GsmNbCells extends ArrayList<a> {

    public static class a {
        public int a() {
            return 0;
        }

        public int b() {
            return 0;
        }

        public byte c() {
            return (byte) 0;
        }

        public int d() {
            return g.a((short) 0);
        }

        public byte e() {
            return (byte) 1;
        }

        public String toString() {
            return "GsmNbCell{lac=0, cellId=0, signal=0, cellAge=0}";
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "GsmNbCells{" + super.toString() + "}";
    }
}
