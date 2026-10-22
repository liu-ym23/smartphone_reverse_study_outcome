package org.yaml.snakeyaml.serializer;

import java.text.NumberFormat;
import org.yaml.snakeyaml.nodes.Node;

/* loaded from: classes5.dex */
public class NumberAnchorGenerator implements AnchorGenerator {
    private int lastAnchorId;

    public NumberAnchorGenerator(int i10) {
        this.lastAnchorId = i10;
    }

    @Override // org.yaml.snakeyaml.serializer.AnchorGenerator
    public String nextAnchor(Node node) {
        if (node.getAnchor() != null) {
            return node.getAnchor();
        }
        this.lastAnchorId++;
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumIntegerDigits(3);
        numberInstance.setMaximumFractionDigits(0);
        numberInstance.setGroupingUsed(false);
        return "id" + numberInstance.format(this.lastAnchorId);
    }
}
