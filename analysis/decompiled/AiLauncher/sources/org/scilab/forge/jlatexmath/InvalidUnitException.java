package org.scilab.forge.jlatexmath;

/* loaded from: classes5.dex */
public class InvalidUnitException extends JMathTeXException {
    public InvalidUnitException() {
        super("The delimiter type was not valid! Use one of the unit constants from the class 'TeXConstants'.");
    }
}
