package org.tensorflow;

import r3.a;
import r3.b;

/* loaded from: classes2.dex */
public final class Operation {

    /* renamed from: a, reason: collision with root package name */
    public final long f13817a;

    /* renamed from: b, reason: collision with root package name */
    public final Graph f13818b;

    public Operation(Graph graph, long j4) {
        this.f13818b = graph;
        this.f13817a = j4;
    }

    private static native int dtype(long j4, long j5, int i4);

    private static native String name(long j4);

    private static native long[] shape(long j4, long j5, int i4);

    private static native String type(long j4);

    public final a a(int i4) {
        b bVarD = this.f13818b.d();
        try {
            return a.a(dtype(bVarD.a(), this.f13817a, i4));
        } finally {
            bVarD.close();
        }
    }

    public final String b() {
        b bVarD = this.f13818b.d();
        try {
            return name(this.f13817a);
        } finally {
            bVarD.close();
        }
    }

    public final long[] c(int i4) {
        b bVarD = this.f13818b.d();
        try {
            return shape(bVarD.a(), this.f13817a, i4);
        } finally {
            bVarD.close();
        }
    }

    public final String d() {
        b bVarD = this.f13818b.d();
        try {
            return type(this.f13817a);
        } finally {
            bVarD.close();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Operation)) {
            return false;
        }
        Operation operation = (Operation) obj;
        Graph graph = operation.f13818b;
        Graph graph2 = this.f13818b;
        if (graph2 != graph) {
            return false;
        }
        b bVarD = graph2.d();
        try {
            return this.f13817a == operation.f13817a;
        } finally {
            bVarD.close();
        }
    }

    public final int hashCode() {
        return Long.valueOf(this.f13817a).hashCode();
    }

    public final String toString() {
        return "<" + d() + " '" + b() + "'>";
    }
}
