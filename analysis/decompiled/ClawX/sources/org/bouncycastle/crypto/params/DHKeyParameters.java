package org.bouncycastle.crypto.params;

/* loaded from: classes.dex */
public class DHKeyParameters extends AsymmetricKeyParameter {
    private DHParameters params;

    public DHKeyParameters(boolean z, DHParameters dHParameters) {
        super(z);
        this.params = dHParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHKeyParameters)) {
            return false;
        }
        DHKeyParameters dHKeyParameters = (DHKeyParameters) obj;
        DHParameters dHParameters = this.params;
        return dHParameters == null ? dHKeyParameters.getParameters() == null : dHParameters.equals(dHKeyParameters.getParameters());
    }

    public DHParameters getParameters() {
        return this.params;
    }

    public int hashCode() {
        int i8 = !isPrivate() ? 1 : 0;
        DHParameters dHParameters = this.params;
        return dHParameters != null ? dHParameters.hashCode() ^ i8 : i8;
    }
}
