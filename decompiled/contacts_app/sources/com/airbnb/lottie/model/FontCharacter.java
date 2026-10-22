package com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FontCharacter {
    private final char character;
    private final String fontFamily;
    private final List<ShapeGroup> shapes;
    private final double size;
    private final String style;
    private final double width;

    public static int hashFor(char r0, String r1, String r2) {
        return (((r0 * 31) + r1.hashCode()) * 31) + r2.hashCode();
    }

    public FontCharacter(List<ShapeGroup> r1, char r2, double r3, double r5, String r7, String r8) {
        this.shapes = r1;
        this.character = r2;
        this.size = r3;
        this.width = r5;
        this.style = r7;
        this.fontFamily = r8;
    }

    public List<ShapeGroup> getShapes() {
        return this.shapes;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return hashFor(this.character, this.fontFamily, this.style);
    }
}
