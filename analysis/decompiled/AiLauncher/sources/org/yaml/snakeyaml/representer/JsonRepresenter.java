package org.yaml.snakeyaml.representer;

import java.util.Base64;
import java.util.Date;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.SafeRepresenter;

/* loaded from: classes5.dex */
public class JsonRepresenter extends Representer {

    public class RepresentByteArray implements Represent {
        public RepresentByteArray() {
        }

        @Override // org.yaml.snakeyaml.representer.Represent
        public Node representData(Object obj) {
            return JsonRepresenter.this.representScalar(Tag.STR, Base64.getEncoder().encodeToString((byte[]) obj));
        }
    }

    public class RepresentDate extends SafeRepresenter.RepresentDate {
        public RepresentDate() {
            super();
        }

        @Override // org.yaml.snakeyaml.representer.SafeRepresenter.RepresentDate
        public Tag getDefaultTag() {
            return Tag.STR;
        }
    }

    public JsonRepresenter(DumperOptions dumperOptions) {
        super(dumperOptions);
        this.representers.put(byte[].class, new RepresentByteArray());
        this.multiRepresenters.put(Date.class, new RepresentDate());
        if (dumperOptions.getDefaultScalarStyle() != DumperOptions.ScalarStyle.JSON_SCALAR_STYLE) {
            throw new IllegalStateException("JSON requires ScalarStyle.JSON_SCALAR_STYLE");
        }
        if (dumperOptions.getNonPrintableStyle() != DumperOptions.NonPrintableStyle.ESCAPE) {
            throw new IllegalStateException("JSON requires NonPrintableStyle.ESCAPE");
        }
    }
}
