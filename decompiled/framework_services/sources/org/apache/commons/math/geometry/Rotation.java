package org.apache.commons.math.geometry;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;
import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class Rotation implements Serializable {
    public static final Rotation IDENTITY = null;
    private static final long serialVersionUID = -2153622329907944313L;
    private final double q0;
    private final double q1;
    private final double q2;
    private final double q3;

    static {
        IDENTITY = new Rotation(1.0d, 0.0d, 0.0d, 0.0d, false);
    }

    public Rotation(double q0, double q1, double q2, double q3, boolean needsNormalization) {
        if (needsNormalization == false) goto L5;
        double inv = 1.0d / FastMath.sqrt((((q0 * q0) + (q1 * q1)) + (q2 * q2)) + (q3 * q3));
        q0 = q0 * inv;
        q1 = q1 * inv;
        q2 = q2 * inv;
        q3 = q3 * inv;
    L5:
        this.q0 = q0;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    public Rotation(Vector3D axis, double angle) {
        double norm = axis.getNorm();
        if (norm == 0.0d) goto L7;
        double halfAngle = (-0.5d) * angle;
        double coeff = FastMath.sin(halfAngle) / norm;
        this.q0 = FastMath.cos(halfAngle);
        this.q1 = axis.getX() * coeff;
        this.q2 = axis.getY() * coeff;
        this.q3 = axis.getZ() * coeff;
        return;
    L7:
        throw MathRuntimeException.createArithmeticException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS, new Object[0]);
    }

    public Rotation(double[][] m, double threshold) throws NotARotationMatrixException {
        if (m.length != 3) goto L26;
        if (m[0].length != 3) goto L26;
        if (m[1].length != 3) goto L26;
        if (m[2].length != 3) goto L26;
        double[][] ort = orthogonalizeMatrix(m, threshold);
        double det = ((ort[0][0] * ((ort[1][1] * ort[2][2]) - (ort[2][1] * ort[1][2]))) - (ort[1][0] * ((ort[0][1] * ort[2][2]) - (ort[2][1] * ort[0][2])))) + (ort[2][0] * ((ort[0][1] * ort[1][2]) - (ort[1][1] * ort[0][2])));
        if (det < 0.0d) goto L24;
        double s = (ort[0][0] + ort[1][1]) + ort[2][2];
        if (s <= (-0.19d)) goto L15;
        this.q0 = FastMath.sqrt(1.0d + s) * 0.5d;
        double inv = 0.25d / this.q0;
        this.q1 = (ort[1][2] - ort[2][1]) * inv;
        this.q2 = (ort[2][0] - ort[0][2]) * inv;
        this.q3 = (ort[0][1] - ort[1][0]) * inv;
        return;
    L15:
        double s2 = (ort[0][0] - ort[1][1]) - ort[2][2];
        if (s2 <= (-0.19d)) goto L18;
        this.q1 = FastMath.sqrt(1.0d + s2) * 0.5d;
        double inv2 = 0.25d / this.q1;
        this.q0 = (ort[1][2] - ort[2][1]) * inv2;
        this.q2 = (ort[0][1] + ort[1][0]) * inv2;
        this.q3 = (ort[0][2] + ort[2][0]) * inv2;
        return;
    L18:
        double s3 = (ort[1][1] - ort[0][0]) - ort[2][2];
        if (s3 <= (-0.19d)) goto L21;
        this.q2 = FastMath.sqrt(1.0d + s3) * 0.5d;
        double inv3 = 0.25d / this.q2;
        this.q0 = (ort[2][0] - ort[0][2]) * inv3;
        this.q1 = (ort[0][1] + ort[1][0]) * inv3;
        this.q3 = (ort[2][1] + ort[1][2]) * inv3;
        return;
    L21:
        this.q3 = FastMath.sqrt(1.0d + ((ort[2][2] - ort[0][0]) - ort[1][1])) * 0.5d;
        double inv4 = 0.25d / this.q3;
        this.q0 = (ort[0][1] - ort[1][0]) * inv4;
        this.q1 = (ort[0][2] + ort[2][0]) * inv4;
        this.q2 = (ort[2][1] + ort[1][2]) * inv4;
        return;
    L24:
        throw new NotARotationMatrixException(LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, new Object[]{Double.valueOf(det)});
    L26:
        throw new NotARotationMatrixException(LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, new Object[]{Integer.valueOf(m.length), Integer.valueOf(m[0].length)});
    }

    public Rotation(Vector3D u1, Vector3D u2, Vector3D v1, Vector3D v2) {
        double u1u1 = Vector3D.dotProduct(u1, u1);
        double u2u2 = Vector3D.dotProduct(u2, u2);
        double v1v1 = Vector3D.dotProduct(v1, v1);
        double v2v2 = Vector3D.dotProduct(v2, v2);
        if (u1u1 == 0.0d) goto L24;
        if (u2u2 == 0.0d) goto L24;
        if (v1v1 == 0.0d) goto L24;
        if (v2v2 == 0.0d) goto L24;
        double u1x = u1.getX();
        double u1y = u1.getY();
        double u1z = u1.getZ();
        double u2x = u2.getX();
        double u2y = u2.getY();
        double u2z = u2.getZ();
        double coeff = FastMath.sqrt(u1u1 / v1v1);
        double v1x = coeff * v1.getX();
        double v1y = coeff * v1.getY();
        double v1z = coeff * v1.getZ();
        Vector3D v3 = new Vector3D(v1x, v1y, v1z);
        double u1u2 = Vector3D.dotProduct(u1, u2);
        double v1v2 = Vector3D.dotProduct(v3, v2);
        double coeffU = u1u2 / u1u1;
        double coeffV = v1v2 / u1u1;
        double beta = FastMath.sqrt((u2u2 - (u1u2 * coeffU)) / (v2v2 - (v1v2 * coeffV)));
        double alpha = coeffU - (beta * coeffV);
        double v2x = (alpha * v1x) + (v2.getX() * beta);
        double v2y = (alpha * v1y) + (v2.getY() * beta);
        double v2z = (alpha * v1z) + (v2.getZ() * beta);
        Vector3D v4 = new Vector3D(v2x, v2y, v2z);
        Vector3D uRef = u1;
        double dx1 = v1x - u1.getX();
        double dy1 = v1y - u1.getY();
        double dz1 = v1z - u1.getZ();
        double dx2 = v2x - u2.getX();
        double dy2 = v2y - u2.getY();
        double dz2 = v2z - u2.getZ();
        Vector3D k = new Vector3D((dy1 * dz2) - (dz1 * dy2), (dz1 * dx2) - (dx1 * dz2), (dx1 * dy2) - (dy1 * dx2));
        double c = ((k.getX() * ((u1y * u2z) - (u1z * u2y))) + (k.getY() * ((u1z * u2x) - (u1x * u2z)))) + (k.getZ() * ((u1x * u2y) - (u1y * u2x)));
        if (c != 0.0d) goto L20;
        Vector3D u3 = Vector3D.crossProduct(u1, u2);
        Vector3D v5 = Vector3D.crossProduct(v3, v4);
        double u3x = u3.getX();
        double u3y = u3.getY();
        double u3z = u3.getZ();
        double v3x = v5.getX();
        double v3y = v5.getY();
        double v3z = v5.getZ();
        double dx3 = v3x - u3x;
        double dy3 = v3y - u3y;
        double dz3 = v3z - u3z;
        k = new Vector3D((dy1 * dz3) - (dz1 * dy3), (dz1 * dx3) - (dx1 * dz3), (dx1 * dy3) - (dy1 * dx3));
        c = ((k.getX() * ((u1y * u3z) - (u1z * u3y))) + (k.getY() * ((u1z * u3x) - (u1x * u3z)))) + (k.getZ() * ((u1x * u3y) - (u1y * u3x)));
        if (c != 0.0d) goto L19;
        k = new Vector3D((dy2 * dz3) - (dz2 * dy3), (dz2 * dx3) - (dx2 * dz3), (dx2 * dy3) - (dy2 * dx3));
        c = ((k.getX() * ((u2y * u3z) - (u2z * u3y))) + (k.getY() * ((u2z * u3x) - (u2x * u3z)))) + (k.getZ() * ((u2x * u3y) - (u2y * u3x)));
        if (c != 0.0d) goto L18;
        this.q0 = 1.0d;
        this.q1 = 0.0d;
        this.q2 = 0.0d;
        this.q3 = 0.0d;
        return;
    L18:
        uRef = u2;
        Vector3D vRef = v4;
    L21:
        double c2 = FastMath.sqrt(c);
        double inv = 1.0d / (c2 + c2);
        this.q1 = inv * k.getX();
        this.q2 = k.getY() * inv;
        this.q3 = k.getZ() * inv;
        double r1 = uRef.getY();
        double r73 = (this.q3 * r1) - (uRef.getZ() * this.q2);
        double r2 = uRef.getZ();
        double r75 = (this.q1 * r2) - (uRef.getX() * this.q3);
        double r3 = uRef.getX();
        Vector3D k2 = new Vector3D(r73, r75, (this.q2 * r3) - (uRef.getY() * this.q1));
        double c3 = Vector3D.dotProduct(k2, k2);
        this.q0 = Vector3D.dotProduct(vRef, k2) / (c3 + c3);
        return;
    L19:
        vRef = v3;
        goto L21
    L20:
        vRef = v3;
    L24:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR, new Object[0]);
    }

    public Rotation(Vector3D u, Vector3D v) {
        double normProduct = u.getNorm() * v.getNorm();
        if (normProduct == 0.0d) goto L10;
        double dot = Vector3D.dotProduct(u, v);
        if (dot >= ((-0.999999999999998d) * normProduct)) goto L7;
        Vector3D w = u.orthogonal();
        this.q0 = 0.0d;
        this.q1 = -w.getX();
        this.q2 = -w.getY();
        this.q3 = -w.getZ();
        return;
    L7:
        this.q0 = FastMath.sqrt(((dot / normProduct) + 1.0d) * 0.5d);
        double coeff = 1.0d / ((this.q0 * 2.0d) * normProduct);
        this.q1 = ((v.getY() * u.getZ()) - (v.getZ() * u.getY())) * coeff;
        this.q2 = ((v.getZ() * u.getX()) - (v.getX() * u.getZ())) * coeff;
        this.q3 = ((v.getX() * u.getY()) - (v.getY() * u.getX())) * coeff;
        return;
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR, new Object[0]);
    }

    public Rotation(RotationOrder order, double alpha1, double alpha2, double alpha3) {
        Rotation r1 = new Rotation(order.getA1(), alpha1);
        Rotation r2 = new Rotation(order.getA2(), alpha2);
        Rotation r3 = new Rotation(order.getA3(), alpha3);
        Rotation composed = r1.applyTo(r2.applyTo(r3));
        this.q0 = composed.q0;
        this.q1 = composed.q1;
        this.q2 = composed.q2;
        this.q3 = composed.q3;
    }

    public Rotation revert() {
        return new Rotation(-this.q0, this.q1, this.q2, this.q3, false);
    }

    public double getQ0() {
        return this.q0;
    }

    public double getQ1() {
        return this.q1;
    }

    public double getQ2() {
        return this.q2;
    }

    public double getQ3() {
        return this.q3;
    }

    public Vector3D getAxis() {
        double squaredSine = ((this.q1 * this.q1) + (this.q2 * this.q2)) + (this.q3 * this.q3);
        if (squaredSine != 0.0d) goto L7;
        return new Vector3D(1.0d, 0.0d, 0.0d);
    L7:
        if (this.q0 >= 0.0d) goto L10;
        double inverse = 1.0d / FastMath.sqrt(squaredSine);
        return new Vector3D(this.q1 * inverse, this.q2 * inverse, this.q3 * inverse);
    L10:
        double inverse2 = (-1.0d) / FastMath.sqrt(squaredSine);
        return new Vector3D(this.q1 * inverse2, this.q2 * inverse2, this.q3 * inverse2);
    }

    public double getAngle() {
        if (this.q0 < (-0.1d)) goto L14;
        if (this.q0 > 0.1d) goto L14;
        if (this.q0 >= 0.0d) goto L12;
        return FastMath.acos(-this.q0) * 2.0d;
    L12:
        return FastMath.acos(this.q0) * 2.0d;
    L14:
        return FastMath.asin(FastMath.sqrt(((this.q1 * this.q1) + (this.q2 * this.q2)) + (this.q3 * this.q3))) * 2.0d;
    }

    public double[] getAngles(RotationOrder order) throws CardanEulerSingularityException {
        if (order != RotationOrder.XYZ) goto L13;
        Vector3D v1 = applyTo(Vector3D.PLUS_K);
        Vector3D v2 = applyInverseTo(Vector3D.PLUS_I);
        if (v2.getZ() < (-0.9999999999d)) goto L11;
        if (v2.getZ() > 0.9999999999d) goto L11;
        return new double[]{FastMath.atan2(-v1.getY(), v1.getZ()), FastMath.asin(v2.getZ()), FastMath.atan2(-v2.getY(), v2.getX())};
    L11:
        throw new CardanEulerSingularityException(true);
    L13:
        if (order != RotationOrder.XZY) goto L23;
        Vector3D v3 = applyTo(Vector3D.PLUS_J);
        Vector3D v4 = applyInverseTo(Vector3D.PLUS_I);
        if (v4.getY() < (-0.9999999999d)) goto L21;
        if (v4.getY() > 0.9999999999d) goto L21;
        return new double[]{FastMath.atan2(v3.getZ(), v3.getY()), -FastMath.asin(v4.getY()), FastMath.atan2(v4.getZ(), v4.getX())};
    L21:
        throw new CardanEulerSingularityException(true);
    L23:
        if (order != RotationOrder.YXZ) goto L33;
        Vector3D v5 = applyTo(Vector3D.PLUS_K);
        Vector3D v6 = applyInverseTo(Vector3D.PLUS_J);
        if (v6.getZ() < (-0.9999999999d)) goto L31;
        if (v6.getZ() > 0.9999999999d) goto L31;
        return new double[]{FastMath.atan2(v5.getX(), v5.getZ()), -FastMath.asin(v6.getZ()), FastMath.atan2(v6.getX(), v6.getY())};
    L31:
        throw new CardanEulerSingularityException(true);
    L33:
        if (order != RotationOrder.YZX) goto L43;
        Vector3D v7 = applyTo(Vector3D.PLUS_I);
        Vector3D v8 = applyInverseTo(Vector3D.PLUS_J);
        if (v8.getX() < (-0.9999999999d)) goto L41;
        if (v8.getX() > 0.9999999999d) goto L41;
        return new double[]{FastMath.atan2(-v7.getZ(), v7.getX()), FastMath.asin(v8.getX()), FastMath.atan2(-v8.getZ(), v8.getY())};
    L41:
        throw new CardanEulerSingularityException(true);
    L43:
        if (order != RotationOrder.ZXY) goto L53;
        Vector3D v9 = applyTo(Vector3D.PLUS_J);
        Vector3D v10 = applyInverseTo(Vector3D.PLUS_K);
        if (v10.getY() < (-0.9999999999d)) goto L51;
        if (v10.getY() > 0.9999999999d) goto L51;
        return new double[]{FastMath.atan2(-v9.getX(), v9.getY()), FastMath.asin(v10.getY()), FastMath.atan2(-v10.getX(), v10.getZ())};
    L51:
        throw new CardanEulerSingularityException(true);
    L53:
        if (order != RotationOrder.ZYX) goto L63;
        Vector3D v11 = applyTo(Vector3D.PLUS_I);
        Vector3D v12 = applyInverseTo(Vector3D.PLUS_K);
        if (v12.getX() < (-0.9999999999d)) goto L61;
        if (v12.getX() > 0.9999999999d) goto L61;
        return new double[]{FastMath.atan2(v11.getY(), v11.getX()), -FastMath.asin(v12.getX()), FastMath.atan2(v12.getY(), v12.getZ())};
    L61:
        throw new CardanEulerSingularityException(true);
    L63:
        if (order != RotationOrder.XYX) goto L73;
        Vector3D v13 = applyTo(Vector3D.PLUS_I);
        Vector3D v14 = applyInverseTo(Vector3D.PLUS_I);
        if (v14.getX() < (-0.9999999999d)) goto L71;
        if (v14.getX() > 0.9999999999d) goto L71;
        return new double[]{FastMath.atan2(v13.getY(), -v13.getZ()), FastMath.acos(v14.getX()), FastMath.atan2(v14.getY(), v14.getZ())};
    L71:
        throw new CardanEulerSingularityException(false);
    L73:
        if (order != RotationOrder.XZX) goto L83;
        Vector3D v15 = applyTo(Vector3D.PLUS_I);
        Vector3D v16 = applyInverseTo(Vector3D.PLUS_I);
        if (v16.getX() < (-0.9999999999d)) goto L81;
        if (v16.getX() > 0.9999999999d) goto L81;
        return new double[]{FastMath.atan2(v15.getZ(), v15.getY()), FastMath.acos(v16.getX()), FastMath.atan2(v16.getZ(), -v16.getY())};
    L81:
        throw new CardanEulerSingularityException(false);
    L83:
        if (order != RotationOrder.YXY) goto L93;
        Vector3D v17 = applyTo(Vector3D.PLUS_J);
        Vector3D v18 = applyInverseTo(Vector3D.PLUS_J);
        if (v18.getY() < (-0.9999999999d)) goto L91;
        if (v18.getY() > 0.9999999999d) goto L91;
        return new double[]{FastMath.atan2(v17.getX(), v17.getZ()), FastMath.acos(v18.getY()), FastMath.atan2(v18.getX(), -v18.getZ())};
    L91:
        throw new CardanEulerSingularityException(false);
    L93:
        if (order != RotationOrder.YZY) goto L103;
        Vector3D v19 = applyTo(Vector3D.PLUS_J);
        Vector3D v20 = applyInverseTo(Vector3D.PLUS_J);
        if (v20.getY() < (-0.9999999999d)) goto L101;
        if (v20.getY() > 0.9999999999d) goto L101;
        return new double[]{FastMath.atan2(v19.getZ(), -v19.getX()), FastMath.acos(v20.getY()), FastMath.atan2(v20.getZ(), v20.getX())};
    L101:
        throw new CardanEulerSingularityException(false);
    L103:
        if (order != RotationOrder.ZXZ) goto L112;
        Vector3D v21 = applyTo(Vector3D.PLUS_K);
        Vector3D v22 = applyInverseTo(Vector3D.PLUS_K);
        if (v22.getZ() < (-0.9999999999d)) goto L111;
        if (v22.getZ() > 0.9999999999d) goto L111;
        return new double[]{FastMath.atan2(v21.getX(), -v21.getY()), FastMath.acos(v22.getZ()), FastMath.atan2(v22.getX(), v22.getY())};
    L111:
        throw new CardanEulerSingularityException(false);
    L112:
        Vector3D v23 = applyTo(Vector3D.PLUS_K);
        Vector3D v24 = applyInverseTo(Vector3D.PLUS_K);
        if (v24.getZ() < (-0.9999999999d)) goto L119;
        if (v24.getZ() > 0.9999999999d) goto L119;
        return new double[]{FastMath.atan2(v23.getY(), v23.getX()), FastMath.acos(v24.getZ()), FastMath.atan2(v24.getY(), -v24.getX())};
    L119:
        throw new CardanEulerSingularityException(false);
    }

    public double[][] getMatrix() {
        double q0q0 = this.q0 * this.q0;
        double q0q1 = this.q0 * this.q1;
        double q0q2 = this.q0 * this.q2;
        double q0q3 = this.q0 * this.q3;
        double q1q1 = this.q1 * this.q1;
        double q1q2 = this.q1 * this.q2;
        double q1q3 = this.q1 * this.q3;
        double q2q2 = this.q2 * this.q2;
        double q2q3 = this.q2;
        double q2q4 = this.q3 * q2q3;
        double q3q3 = this.q3 * this.q3;
        double[][] m = {new double[3], new double[3], new double[3]};
        m[0][0] = ((q0q0 + q1q1) * 2.0d) - 1.0d;
        m[1][0] = (q1q2 - q0q3) * 2.0d;
        m[2][0] = (q1q3 + q0q2) * 2.0d;
        m[0][1] = (q1q2 + q0q3) * 2.0d;
        m[1][1] = ((q0q0 + q2q2) * 2.0d) - 1.0d;
        m[2][1] = (q2q4 - q0q1) * 2.0d;
        m[0][2] = (q1q3 - q0q2) * 2.0d;
        m[1][2] = (q2q4 + q0q1) * 2.0d;
        m[2][2] = ((q0q0 + q3q3) * 2.0d) - 1.0d;
        return m;
    }

    public Vector3D applyTo(Vector3D u) {
        double x = u.getX();
        double y = u.getY();
        double z = u.getZ();
        double s = ((this.q1 * x) + (this.q2 * y)) + (this.q3 * z);
        return new Vector3D((((this.q0 * ((this.q0 * x) - ((this.q2 * z) - (this.q3 * y)))) + (this.q1 * s)) * 2.0d) - x, (((this.q0 * ((this.q0 * y) - ((this.q3 * x) - (this.q1 * z)))) + (this.q2 * s)) * 2.0d) - y, (((this.q0 * ((this.q0 * z) - ((this.q1 * y) - (this.q2 * x)))) + (this.q3 * s)) * 2.0d) - z);
    }

    public Vector3D applyInverseTo(Vector3D u) {
        double x = u.getX();
        double y = u.getY();
        double z = u.getZ();
        double s = ((this.q1 * x) + (this.q2 * y)) + (this.q3 * z);
        double m0 = -this.q0;
        return new Vector3D((((((x * m0) - ((this.q2 * z) - (this.q3 * y))) * m0) + (this.q1 * s)) * 2.0d) - x, (((((y * m0) - ((this.q3 * x) - (this.q1 * z))) * m0) + (this.q2 * s)) * 2.0d) - y, (((((z * m0) - ((this.q1 * y) - (this.q2 * x))) * m0) + (this.q3 * s)) * 2.0d) - z);
    }

    public Rotation applyTo(Rotation r) {
        return new Rotation((r.q0 * this.q0) - (((r.q1 * this.q1) + (r.q2 * this.q2)) + (r.q3 * this.q3)), ((r.q1 * this.q0) + (r.q0 * this.q1)) + ((r.q2 * this.q3) - (r.q3 * this.q2)), ((r.q2 * this.q0) + (r.q0 * this.q2)) + ((r.q3 * this.q1) - (r.q1 * this.q3)), ((r.q3 * this.q0) + (r.q0 * this.q3)) + ((r.q1 * this.q2) - (r.q2 * this.q1)), false);
    }

    public Rotation applyInverseTo(Rotation r) {
        return new Rotation(((-r.q0) * this.q0) - (((r.q1 * this.q1) + (r.q2 * this.q2)) + (r.q3 * this.q3)), (((-r.q1) * this.q0) + (r.q0 * this.q1)) + ((r.q2 * this.q3) - (r.q3 * this.q2)), (((-r.q2) * this.q0) + (r.q0 * this.q2)) + ((r.q3 * this.q1) - (r.q1 * this.q3)), (((-r.q3) * this.q0) + (r.q0 * this.q3)) + ((r.q1 * this.q2) - (r.q2 * this.q1)), false);
    }

    private double[][] orthogonalizeMatrix(double[][] m, double threshold) throws NotARotationMatrixException {
        double[] m0 = m[0];
        double[] m1 = m[1];
        int i = 2;
        double[] m2 = m[2];
        double x00 = m0[0];
        double x01 = m0[1];
        double x02 = m0[2];
        double x10 = m1[0];
        double x11 = m1[1];
        double x12 = m1[2];
        double x20 = m2[0];
        double x21 = m2[1];
        double x22 = m2[2];
        double fn = 0.0d;
        double[][] o = (double[][]) Array.newInstance(Double.TYPE, new int[]{3, 3});
        double[] o0 = o[0];
        double[] o1 = o[1];
        double[] o2 = o[2];
        int i2 = 0;
    L3:
        int r31 = i;
        int i3 = i2 + 1;
        double[][] o3 = o;
        if (i3 >= 11) goto L10;
        double mx00 = ((m0[0] * x00) + (m1[0] * x10)) + (m2[0] * x20);
        double mx10 = ((m0[1] * x00) + (m1[1] * x10)) + (m2[1] * x20);
        double mx20 = ((m0[r31] * x00) + (m1[r31] * x10)) + (m2[r31] * x20);
        double mx01 = ((m0[0] * x01) + (m1[0] * x11)) + (m2[0] * x21);
        double mx11 = ((m0[1] * x01) + (m1[1] * x11)) + (m2[1] * x21);
        double mx21 = ((m0[r31] * x01) + (m1[r31] * x11)) + (m2[r31] * x21);
        double mx02 = ((m0[0] * x02) + (m1[0] * x12)) + (m2[0] * x22);
        double mx12 = ((m0[1] * x02) + (m1[1] * x12)) + (m2[1] * x22);
        double mx22 = ((m0[r31] * x02) + (m1[r31] * x12)) + (m2[r31] * x22);
        o0[0] = x00 - (((((x00 * mx00) + (x01 * mx10)) + (x02 * mx20)) - m0[0]) * 0.5d);
        o0[1] = x01 - (((((x00 * mx01) + (x01 * mx11)) + (x02 * mx21)) - m0[1]) * 0.5d);
        o0[r31] = x02 - (((((x00 * mx02) + (x01 * mx12)) + (x02 * mx22)) - m0[r31]) * 0.5d);
        o1[0] = x10 - (((((x10 * mx00) + (x11 * mx10)) + (x12 * mx20)) - m1[0]) * 0.5d);
        o1[1] = x11 - (((((x10 * mx01) + (x11 * mx11)) + (x12 * mx21)) - m1[1]) * 0.5d);
        o1[r31] = x12 - (((((x10 * mx02) + (x11 * mx12)) + (x12 * mx22)) - m1[r31]) * 0.5d);
        o2[0] = x20 - (((((x20 * mx00) + (x21 * mx10)) + (x22 * mx20)) - m2[0]) * 0.5d);
        o2[1] = x21 - (((((x20 * mx01) + (x21 * mx11)) + (x22 * mx21)) - m2[1]) * 0.5d);
        o2[r31] = x22 - (((((x20 * mx02) + (x21 * mx12)) + (x22 * mx22)) - m2[r31]) * 0.5d);
        double corr00 = o0[0] - m0[0];
        double corr01 = o0[1] - m0[1];
        double corr02 = o0[r31] - m0[r31];
        double corr10 = o1[0] - m1[0];
        double corr11 = o1[1] - m1[1];
        double corr12 = o1[r31] - m1[r31];
        double corr20 = o2[0] - m2[0];
        double corr21 = o2[1] - m2[1];
        double corr22 = o2[r31] - m2[r31];
        double fn1 = ((((((((corr00 * corr00) + (corr01 * corr01)) + (corr02 * corr02)) + (corr10 * corr10)) + (corr11 * corr11)) + (corr12 * corr12)) + (corr20 * corr20)) + (corr21 * corr21)) + (corr22 * corr22);
        if (FastMath.abs(fn1 - fn) <= threshold) goto L7;
        x00 = o0[0];
        x01 = o0[1];
        x02 = o0[r31];
        x10 = o1[0];
        x11 = o1[1];
        x12 = o1[r31];
        x20 = o2[0];
        x21 = o2[1];
        x22 = o2[r31];
        fn = fn1;
        o = o3;
        i2 = i3;
        i = r31;
        goto L3
    L7:
        return o3;
    L10:
        throw new NotARotationMatrixException(LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX, new Object[]{Integer.valueOf(i3 - 1)});
    }

    public static double distance(Rotation r1, Rotation r2) {
        return r1.applyInverseTo(r2).getAngle();
    }
}
