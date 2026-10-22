package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.amap.api.col.s.ce;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class AwtCodec implements ObjectSerializer, ObjectDeserializer {
    public static final AwtCodec instance = null;

    public AwtCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    static {
        instance = new AwtCodec();
    }

    public static boolean support(Class<?> r100) {
        if (r100 != Point.class) goto L5;
    L12:
        return true;
    L5:
        if (r100 == Rectangle.class) goto L12;
        if (r100 == Font.class) goto L12;
        if (r100 == Color.class) goto L12;
        return false;
    }

    public Color parseColor(DefaultJSONParser r110) {
        JSONLexer r111 = r110.lexer;
        int r100 = 0;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r111.token() == 13) goto L5;
        if (r111.token() != 4) goto L31;
        String r104 = r111.stringVal();
        r111.nextTokenWithColon(2);
        if (r111.token() != 2) goto L29;
        int r105 = r111.intValue();
        r111.nextToken();
        if (r104.equalsIgnoreCase("r") == false) goto L15;
        r100 = r105;
    L24:
        if (r111.token() != 16) goto L4;
        r111.nextToken(4);
        goto L4
    L15:
        if (r104.equalsIgnoreCase(ce.f26391f) == false) goto L18;
        r101 = r105;
        goto L24
    L18:
        if (r104.equalsIgnoreCase("b") == false) goto L21;
        r102 = r105;
        goto L24
    L21:
        if (r104.equalsIgnoreCase("alpha") == false) goto L27;
        r103 = r105;
        goto L24
    L27:
        throw new JSONException("syntax error, ".concat(r104));
    L29:
        throw new JSONException("syntax error");
    L31:
        throw new JSONException("syntax error");
    L5:
        r111.nextToken();
        return new Color(r100, r101, r102, r103);
    }

    public Font parseFont(DefaultJSONParser r100) {
        JSONLexer r101 = r100.lexer;
        int r102 = 0;
        String r103 = null;
        int r104 = 0;
    L4:
        if (r101.token() == 13) goto L5;
        if (r101.token() != 4) goto L36;
        String r105 = r101.stringVal();
        r101.nextTokenWithColon(2);
        if (r105.equalsIgnoreCase("name") == false) goto L17;
        if (r101.token() != 4) goto L15;
        r103 = r101.stringVal();
        r101.nextToken();
    L29:
        if (r101.token() != 16) goto L4;
        r101.nextToken(4);
        goto L4
    L15:
        throw new JSONException("syntax error");
    L17:
        if (r105.equalsIgnoreCase("style") == false) goto L24;
        if (r101.token() != 2) goto L22;
        r102 = r101.intValue();
        r101.nextToken();
        goto L29
    L22:
        throw new JSONException("syntax error");
    L24:
        if (r105.equalsIgnoreCase("size") == false) goto L34;
        if (r101.token() != 2) goto L32;
        r104 = r101.intValue();
        r101.nextToken();
        goto L29
    L32:
        throw new JSONException("syntax error");
    L34:
        throw new JSONException("syntax error, ".concat(r105));
    L36:
        throw new JSONException("syntax error");
    L5:
        r101.nextToken();
        return new Font(r103, r102, r104);
    }

    public Rectangle parseRectangle(DefaultJSONParser r110) {
        JSONLexer r111 = r110.lexer;
        int r100 = 0;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r111.token() == 13) goto L5;
        if (r111.token() != 4) goto L35;
        String r104 = r111.stringVal();
        r111.nextTokenWithColon(2);
        int r105 = r111.token();
        if (r105 != 2) goto L13;
        int r106 = r111.intValue();
        r111.nextToken();
    L16:
        if (r104.equalsIgnoreCase("x") == false) goto L19;
        r100 = r106;
    L28:
        if (r111.token() != 16) goto L4;
        r111.nextToken(4);
        goto L4
    L19:
        if (r104.equalsIgnoreCase("y") == false) goto L22;
        r101 = r106;
        goto L28
    L22:
        if (r104.equalsIgnoreCase("width") == false) goto L25;
        r102 = r106;
        goto L28
    L25:
        if (r104.equalsIgnoreCase("height") == false) goto L31;
        r103 = r106;
        goto L28
    L31:
        throw new JSONException("syntax error, ".concat(r104));
    L13:
        if (r105 != 3) goto L33;
        r106 = (int) r111.floatValue();
        r111.nextToken();
        goto L16
    L33:
        throw new JSONException("syntax error");
    L35:
        throw new JSONException("syntax error");
    L5:
        r111.nextToken();
        return new Rectangle(r100, r101, r102, r103);
    }

    private Object parseRef(DefaultJSONParser r100, Object r101) {
        JSONLexer r102 = r100.getLexer();
        r102.nextTokenWithColon(4);
        String r103 = r102.stringVal();
        r100.setContext(r100.getContext(), r101);
        r100.addResolveTask(new DefaultJSONParser.ResolveTask(r100.getContext(), r103));
        r100.popContext();
        r100.setResolveStatus(1);
        r102.nextToken(13);
        r100.accept(13);
        return null;
    }

    public Point parsePoint(DefaultJSONParser r100, Object r101) {
        JSONLexer r102 = r100.lexer;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r102.token() == 13) goto L5;
        if (r102.token() != 4) goto L36;
        String r105 = r102.stringVal();
        if (JSON.DEFAULT_TYPE_KEY.equals(r105) == true) goto L11;
        if ("$ref".equals(r105) == true) goto L15;
        r102.nextTokenWithColon(2);
        int r106 = r102.token();
        if (r106 != 2) goto L20;
        int r107 = r102.intValue();
        r102.nextToken();
    L23:
        if (r105.equalsIgnoreCase("x") == false) goto L26;
        r103 = r107;
    L29:
        if (r102.token() != 16) goto L4;
        r102.nextToken(4);
        goto L4
    L26:
        if (r105.equalsIgnoreCase("y") == false) goto L32;
        r104 = r107;
        goto L29
    L32:
        throw new JSONException("syntax error, ".concat(r105));
    L20:
        if (r106 != 3) goto L34;
        r107 = (int) r102.floatValue();
        r102.nextToken();
        goto L23
    L34:
        throw new JSONException("syntax error : " + r102.tokenName());
    L15:
        return (Point) parseRef(r100, r101);
    L11:
        r100.acceptType("java.awt.Point");
        goto L4
    L36:
        throw new JSONException("syntax error");
    L5:
        r102.nextToken();
        return new Point(r103, r104);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r100, Type r101, Object r102) {
        JSONLexer r103 = r100.lexer;
        if (r103.token() != 8) goto L7;
        r103.nextToken(16);
        return null;
    L7:
        if (r103.token() != 12) goto L9;
    L13:
        r103.nextToken();
        if (r101 != Point.class) goto L17;
        T r104 = (T) parsePoint(r100, r102);
    L25:
        ParseContext r105 = r100.getContext();
        r100.setContext(r104, r102);
        r100.setContext(r105);
        return r104;
    L17:
        if (r101 != Rectangle.class) goto L20;
        r104 = (T) parseRectangle(r100);
        goto L25
    L20:
        if (r101 != Color.class) goto L23;
        r104 = (T) parseColor(r100);
        goto L25
    L23:
        if (r101 != Font.class) goto L28;
        r104 = (T) parseFont(r100);
        goto L25
    L28:
        throw new JSONException("not support awt class : " + r101);
    L9:
        if (r103.token() == 16) goto L13;
        throw new JSONException("syntax error");
    }

    public char writeClassName(SerializeWriter r100, Class<?> r101, char r102) {
        if (r100.isEnabled(SerializerFeature.WriteClassName) == false) goto L6;
        r100.write(123);
        r100.writeFieldName(JSON.DEFAULT_TYPE_KEY);
        r100.writeString(r101.getName());
        return ',';
    L6:
        return r102;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r104) throws IOException {
        SerializeWriter r105 = r100.out;
        if (r101 != null) goto L7;
        r105.writeNull();
        return;
    L7:
        if ((r101 instanceof Point) == false) goto L10;
        Point r106 = (Point) r101;
        r105.writeFieldValue(writeClassName(r105, Point.class, '{'), "x", r106.x);
        r105.writeFieldValue(',', "y", r106.y);
    L20:
        r105.write(125);
        return;
    L10:
        if ((r101 instanceof Font) == false) goto L13;
        Font r107 = (Font) r101;
        r105.writeFieldValue(writeClassName(r105, Font.class, '{'), "name", r107.getName());
        r105.writeFieldValue(',', "style", r107.getStyle());
        r105.writeFieldValue(',', "size", r107.getSize());
        goto L20
    L13:
        if ((r101 instanceof Rectangle) == false) goto L16;
        Rectangle r108 = (Rectangle) r101;
        r105.writeFieldValue(writeClassName(r105, Rectangle.class, '{'), "x", r108.x);
        r105.writeFieldValue(',', "y", r108.y);
        r105.writeFieldValue(',', "width", r108.width);
        r105.writeFieldValue(',', "height", r108.height);
        goto L20
    L16:
        if ((r101 instanceof Color) == false) goto L23;
        Color r109 = (Color) r101;
        r105.writeFieldValue(writeClassName(r105, Color.class, '{'), "r", r109.getRed());
        r105.writeFieldValue(',', ce.f26391f, r109.getGreen());
        r105.writeFieldValue(',', "b", r109.getBlue());
        if (r109.getAlpha() <= 0) goto L20;
        r105.writeFieldValue(',', "alpha", r109.getAlpha());
        goto L20
    L23:
        throw new JSONException("not support awt class : ".concat(r101.getClass().getName()));
    }
}
