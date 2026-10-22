package org.apache.commons.math.optimization.linear;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealVector;

/* JADX INFO: loaded from: classes3.dex */
public class LinearConstraint implements Serializable {
    private static final long serialVersionUID = -764632794033034092L;
    private final transient RealVector coefficients;
    private final Relationship relationship;
    private final double value;

    public LinearConstraint(double[] coefficients, Relationship relationship, double value) {
        this(new ArrayRealVector(coefficients), relationship, value);
    }

    public LinearConstraint(RealVector coefficients, Relationship relationship, double value) {
        this.coefficients = coefficients;
        this.relationship = relationship;
        this.value = value;
    }

    public LinearConstraint(double[] lhsCoefficients, double lhsConstant, Relationship relationship, double[] rhsCoefficients, double rhsConstant) {
        double[] sub = new double[lhsCoefficients.length];
        int i = 0;
    L4:
        if (i >= sub.length) goto L6;
        sub[i] = lhsCoefficients[i] - rhsCoefficients[i];
        i = i + 1;
        goto L4
    L6:
        this.coefficients = new ArrayRealVector(sub, false);
        this.relationship = relationship;
        this.value = rhsConstant - lhsConstant;
    }

    public LinearConstraint(RealVector lhsCoefficients, double lhsConstant, Relationship relationship, RealVector rhsCoefficients, double rhsConstant) {
        this.coefficients = lhsCoefficients.subtract(rhsCoefficients);
        this.relationship = relationship;
        this.value = rhsConstant - lhsConstant;
    }

    public RealVector getCoefficients() {
        return this.coefficients;
    }

    public Relationship getRelationship() {
        return this.relationship;
    }

    public double getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if ((other instanceof LinearConstraint) == false) goto L16;
        LinearConstraint rhs = (LinearConstraint) other;
        if (this.relationship != rhs.relationship) goto L15;
        if (this.value != rhs.value) goto L15;
        if (this.coefficients.equals(rhs.coefficients) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        return (this.relationship.hashCode() ^ Double.valueOf(this.value).hashCode()) ^ this.coefficients.hashCode();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        MatrixUtils.serializeRealVector(this.coefficients, oos);
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        MatrixUtils.deserializeRealVector(this, "coefficients", ois);
    }
}
