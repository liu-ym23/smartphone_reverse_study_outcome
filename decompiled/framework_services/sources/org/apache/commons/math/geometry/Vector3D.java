package org.apache.commons.math.geometry;

import java.io.Serializable;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;
import org.apache.commons.math.util.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class Vector3D implements Serializable {
    private static final Vector3DFormat DEFAULT_FORMAT = null;
    public static final Vector3D MINUS_I = null;
    public static final Vector3D MINUS_J = null;
    public static final Vector3D MINUS_K = null;
    public static final Vector3D NEGATIVE_INFINITY = null;
    public static final Vector3D NaN = null;
    public static final Vector3D PLUS_I = null;
    public static final Vector3D PLUS_J = null;
    public static final Vector3D PLUS_K = null;
    public static final Vector3D POSITIVE_INFINITY = null;
    public static final Vector3D ZERO = null;
    private static final long serialVersionUID = 5133268763396045979L;
    private final double x;
    private final double y;
    private final double z;

    static {
        ZERO = new Vector3D(0.0d, 0.0d, 0.0d);
        PLUS_I = new Vector3D(1.0d, 0.0d, 0.0d);
        MINUS_I = new Vector3D(-1.0d, 0.0d, 0.0d);
        PLUS_J = new Vector3D(0.0d, 1.0d, 0.0d);
        MINUS_J = new Vector3D(0.0d, -1.0d, 0.0d);
        PLUS_K = new Vector3D(0.0d, 0.0d, 1.0d);
        MINUS_K = new Vector3D(0.0d, 0.0d, -1.0d);
        NaN = new Vector3D(Double.NaN, Double.NaN, Double.NaN);
        POSITIVE_INFINITY = new Vector3D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        NEGATIVE_INFINITY = new Vector3D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        DEFAULT_FORMAT = Vector3DFormat.getInstance();
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(double alpha, double delta) {
        double cosDelta = FastMath.cos(delta);
        this.x = FastMath.cos(alpha) * cosDelta;
        this.y = FastMath.sin(alpha) * cosDelta;
        this.z = FastMath.sin(delta);
    }

    public Vector3D(double a, Vector3D u) {
        this.x = u.x * a;
        this.y = u.y * a;
        this.z = u.z * a;
    }

    public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2) {
        this.x = (u1.x * a1) + (u2.x * a2);
        this.y = (u1.y * a1) + (u2.y * a2);
        this.z = (u1.z * a1) + (u2.z * a2);
    }

    public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2, double a3, Vector3D u3) {
        this.x = ((u1.x * a1) + (u2.x * a2)) + (u3.x * a3);
        this.y = ((u1.y * a1) + (u2.y * a2)) + (u3.y * a3);
        this.z = ((u1.z * a1) + (u2.z * a2)) + (u3.z * a3);
    }

    public Vector3D(double a1, Vector3D u1, double a2, Vector3D u2, double a3, Vector3D u3, double a4, Vector3D u4) {
        this.x = (((u1.x * a1) + (u2.x * a2)) + (u3.x * a3)) + (u4.x * a4);
        this.y = (((u1.y * a1) + (u2.y * a2)) + (u3.y * a3)) + (u4.y * a4);
        this.z = (((u1.z * a1) + (u2.z * a2)) + (u3.z * a3)) + (u4.z * a4);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double getNorm1() {
        return (FastMath.abs(this.x) + FastMath.abs(this.y)) + FastMath.abs(this.z);
    }

    public double getNorm() {
        return FastMath.sqrt(((this.x * this.x) + (this.y * this.y)) + (this.z * this.z));
    }

    public double getNormSq() {
        return ((this.x * this.x) + (this.y * this.y)) + (this.z * this.z);
    }

    public double getNormInf() {
        return FastMath.max(FastMath.max(FastMath.abs(this.x), FastMath.abs(this.y)), FastMath.abs(this.z));
    }

    public double getAlpha() {
        return FastMath.atan2(this.y, this.x);
    }

    public double getDelta() {
        return FastMath.asin(this.z / getNorm());
    }

    public Vector3D add(Vector3D v) {
        return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public Vector3D add(double factor, Vector3D v) {
        return new Vector3D(this.x + (v.x * factor), this.y + (v.y * factor), this.z + (v.z * factor));
    }

    public Vector3D subtract(Vector3D v) {
        return new Vector3D(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    public Vector3D subtract(double factor, Vector3D v) {
        return new Vector3D(this.x - (v.x * factor), this.y - (v.y * factor), this.z - (v.z * factor));
    }

    public Vector3D normalize() {
        double s = getNorm();
        if (s == 0.0d) goto L7;
        return scalarMultiply(1.0d / s);
    L7:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
    }

    public Vector3D orthogonal() {
        double threshold = getNorm() * 0.6d;
        if (threshold == 0.0d) goto L19;
        if (this.x < (-threshold)) goto L11;
        if (this.x > threshold) goto L11;
        double inverse = 1.0d / FastMath.sqrt((this.y * this.y) + (this.z * this.z));
        return new Vector3D(0.0d, inverse * this.z, (-inverse) * this.y);
    L11:
        if (this.y >= (-threshold)) goto L13;
    L16:
        double inverse2 = 1.0d / FastMath.sqrt((this.x * this.x) + (this.y * this.y));
        double r7 = inverse2 * this.y;
        double r9 = this.x;
        return new Vector3D(r7, r9 * (-inverse2), 0.0d);
    L13:
        if (this.y > threshold) goto L16;
        double inverse3 = 1.0d / FastMath.sqrt((this.x * this.x) + (this.z * this.z));
        double r8 = this.z;
        return new Vector3D(r8 * (-inverse3), 0.0d, inverse3 * this.x);
    L19:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public static double angle(Vector3D v1, Vector3D v2) {
        double normProduct = v1.getNorm() * v2.getNorm();
        if (normProduct == 0.0d) goto L18;
        double dot = dotProduct(v1, v2);
        double threshold = 0.9999d * normProduct;
        if (dot >= (-threshold)) goto L7;
    L11:
        Vector3D v3 = crossProduct(v1, v2);
        if (dot < 0.0d) goto L16;
        return FastMath.asin(v3.getNorm() / normProduct);
    L16:
        return 3.141592653589793d - FastMath.asin(v3.getNorm() / normProduct);
    L7:
        if (dot > threshold) goto L11;
        return FastMath.acos(dot / normProduct);
    L18:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public Vector3D negate() {
        return new Vector3D(-this.x, -this.y, -this.z);
    }

    public Vector3D scalarMultiply(double a) {
        return new Vector3D(this.x * a, this.y * a, this.z * a);
    }

    public boolean isNaN() {
        if (Double.isNaN(this.x) == false) goto L5;
    L10:
        return true;
    L5:
        if (Double.isNaN(this.y) == true) goto L10;
        if (Double.isNaN(this.z) == true) goto L10;
        return false;
    }

    public boolean isInfinite() {
        if (isNaN() == false) goto L5;
    L11:
        return false;
    L5:
        if (Double.isInfinite(this.x) == false) goto L7;
    L10:
        return true;
    L7:
        if (Double.isInfinite(this.y) == true) goto L10;
        if (Double.isInfinite(this.z) == false) goto L11;
        goto L10
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if ((other instanceof Vector3D) == false) goto L20;
        Vector3D rhs = (Vector3D) other;
        if (rhs.isNaN() == false) goto L12;
        return isNaN();
    L12:
        if (this.x != rhs.x) goto L19;
        if (this.y != rhs.y) goto L19;
        if (this.z != rhs.z) goto L19;
        return true;
    L19:
        return false;
    L20:
        return false;
    }

    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 8;
    L7:
        return (((MathUtils.hash(this.x) * 23) + (MathUtils.hash(this.y) * 19)) + MathUtils.hash(this.z)) * 31;
    }

    public static double dotProduct(Vector3D v1, Vector3D v2) {
        return ((v1.x * v2.x) + (v1.y * v2.y)) + (v1.z * v2.z);
    }

    public static Vector3D crossProduct(Vector3D v1, Vector3D v2) {
        return new Vector3D((v1.y * v2.z) - (v1.z * v2.y), (v1.z * v2.x) - (v1.x * v2.z), (v1.x * v2.y) - (v1.y * v2.x));
    }

    public static double distance1(Vector3D v1, Vector3D v2) {
        double dx = FastMath.abs(v2.x - v1.x);
        double dy = FastMath.abs(v2.y - v1.y);
        double dz = FastMath.abs(v2.z - v1.z);
        return (dx + dy) + dz;
    }

    public static double distance(Vector3D v1, Vector3D v2) {
        double dx = v2.x - v1.x;
        double dy = v2.y - v1.y;
        double dz = v2.z - v1.z;
        return FastMath.sqrt(((dx * dx) + (dy * dy)) + (dz * dz));
    }

    public static double distanceInf(Vector3D v1, Vector3D v2) {
        double dx = FastMath.abs(v2.x - v1.x);
        double dy = FastMath.abs(v2.y - v1.y);
        double dz = FastMath.abs(v2.z - v1.z);
        return FastMath.max(FastMath.max(dx, dy), dz);
    }

    public static double distanceSq(Vector3D v1, Vector3D v2) {
        double dx = v2.x - v1.x;
        double dy = v2.y - v1.y;
        double dz = v2.z - v1.z;
        return ((dx * dx) + (dy * dy)) + (dz * dz);
    }

    public String toString() {
        return DEFAULT_FORMAT.format(this);
    }
}
