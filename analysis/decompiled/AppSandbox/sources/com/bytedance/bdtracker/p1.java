package com.bytedance.bdtracker;

import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class p1 {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;

    public p1(boolean z, boolean z2) {
        this.b = z;
        this.c = z2;
        this.d = false;
    }

    public p1(boolean z, boolean z2, boolean z3) {
        this.b = z;
        this.c = z2;
        this.d = z3;
    }

    public abstract String a();

    public abstract boolean a(JSONObject jSONObject);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p1) {
            return Objects.equals(a(), ((p1) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }
}
