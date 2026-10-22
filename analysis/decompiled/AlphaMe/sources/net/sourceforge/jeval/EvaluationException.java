package net.sourceforge.jeval;

/* loaded from: classes2.dex */
public class EvaluationException extends Exception {
    private static final long serialVersionUID = -3010333364122748053L;

    public EvaluationException(String str) {
        super(str);
    }

    public EvaluationException(Exception exc) {
        super(exc);
    }

    public EvaluationException(String str, Exception exc) {
        super(str, exc);
    }
}
