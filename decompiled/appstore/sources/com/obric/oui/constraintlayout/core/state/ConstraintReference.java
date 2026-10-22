package com.obric.oui.constraintlayout.core.state;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ConstraintReference implements Reference {

    public interface ConstraintReferenceFactory {
        ConstraintReference create(State r10);
    }

    public static class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;

        public IncorrectConstraintException(ArrayList<String> r10) {
            this.mErrors = r10;
        }

        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return toString();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }
}
